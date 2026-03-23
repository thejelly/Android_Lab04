package com.example.lab04;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lab04.R;

public class MainActivity extends AppCompatActivity
{
    TextView t1;
    // 该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    int hasData = 0;
    // 记录ProgressBar的完成进度
    int status = 0;
    ProgressBar bar , bar2;
    // 创建一个负责更新的进度的Handler
    public Handler mHandler = new Handler(new Handler.Callback()
    {
        @Override
        public boolean handleMessage(Message msg)
        {
            // 表明消息是由该程序发送的
            if (msg.what == 0x111)
            {
                bar.setProgress(status);
                bar2.setProgress(status);

            }
            return  false;
        }
    });

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        t1=findViewById(R.id.text);
        bar = findViewById(R.id.bar);
        bar2 = findViewById(R.id.bar2);


        // 启动线程来执行任务
        new Thread()
        {
            public void run()
            {
                while (status < 100)
                {
                    // 获取耗时操作的完成百分比
                    status = doWork();

                    // 发送消息
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }
    // 模拟一个耗时的操作
    public int doWork()
    {
        // 为数组元素赋值
        data[hasData++] = (int) (Math.random() * 100);
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return hasData;
    }
}


