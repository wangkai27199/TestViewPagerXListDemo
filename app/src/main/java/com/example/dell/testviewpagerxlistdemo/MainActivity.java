package com.example.dell.testviewpagerxlistdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends Activity {

    //http://qhb.2dyt.com/Bwei/news?type=2&postkey=1503d&page=1

    private ViewPager vp;
    private int[] ids = new int[]{R.id.rb01,R.id.rb02,R.id.rb03};
    private ListView lv;
    private String path = "http://qhb.2dyt.com/Bwei/news?type=2&postkey=1503d&page=1";
    private List<NewsBean.ListBean> list = new ArrayList<NewsBean.ListBean>();
    private List<ImageView> iList = new ArrayList<ImageView>();
    private MyAdapter adapter;
    private int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 0:

                    String results = (String) msg.obj;
                    Gson gson = new Gson();
                    NewsBean newsBean = gson.fromJson(results, NewsBean.class);

                    List<String> listViewPager = newsBean.getListViewPager();

                    for (String url : listViewPager){
                        ImageView imageView = new ImageView(MainActivity.this);
                        ImageLoader.getInstance().displayImage(url,imageView);
                        iList.add(imageView);
                    }
                    List<NewsBean.ListBean> nlist = newsBean.getList();

                    list.addAll(nlist);
                    if (list!= null) {
                        lv.setAdapter(adapter);
                    }


                    break;
                case 1:

                    if (iList!= null){
                        vp.setAdapter(new VAdapter());
                    }

                    count++;
                    if (count == iList.size()){
                        count = 0;
                    }
                    vp.setCurrentItem(count);
                    handler.sendEmptyMessageDelayed(1,2000);
                    break;
            }



        }
    };
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(list,MainActivity.this);

        vp = (ViewPager) findViewById(R.id.vp);
        lv = (ListView) findViewById(R.id.lv);
        rg = (RadioGroup) findViewById(R.id.rg);
        new MyAsyncTask().execute(path);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                rg.check(ids[position]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        handler.sendEmptyMessageDelayed(1,2000);


    }

    //创建异步任务类

    class MyAsyncTask extends AsyncTask<Object,Void,String>{

        String result;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Object... params) {

            String url = (String) params[0];
            InputStream is = null;
            HttpClient client = new DefaultHttpClient();
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,20000);
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,20000);
            HttpGet get = new HttpGet(url);


            try {

                HttpResponse response = client.execute(get);
                if (response.getStatusLine().getStatusCode() == 200){
                    is = response.getEntity().getContent();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = is.read(b))!= -1){
                        bos.write(b,0,len);
                    }
                    result = bos.toString();
                    Log.i("zzzzzzzzzzzzzz",result);
                    bos.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (is != null){
                    try {
                        is.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Message message = Message.obtain();
            message.what = 0;
            message.obj = s;
            handler.sendMessage(message);
        }
    }

   class VAdapter extends PagerAdapter{

       @Override
       public int getCount() {
           return iList.size();
       }

       @Override
       public boolean isViewFromObject(View view, Object object) {
           return view == object;
       }

       @Override
       public Object instantiateItem(ViewGroup container, int position) {
           container.addView(iList.get(position));
           return iList.get(position);
       }

       @Override
       public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(iList.get(position));
       }
   }
}
