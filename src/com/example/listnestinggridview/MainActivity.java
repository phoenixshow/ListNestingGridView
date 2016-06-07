package com.example.listnestinggridview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
/** 
 * Demo����: 
 * ListViewǶ��GridViewʹ����� 
 * ��ListView��ÿ��Item�ж�����һ��GridView 
 * 
 * ע������: 
 * ����ListView��GridView���ǿɻ����Ŀؼ�. 
 * ������Ҫ�Զ���GridView,��д��onMeasure()����. 
 * �ڸ÷�����ʹGridView�ĸ�Ϊwrap_content�Ĵ�С,����GridView�� 
 * ������ֻ����ʾ��Сһ���� 
 * 
 * �ο�����: 
 * 1 http://bbs.csdn.net/topics/380245627 
 * 2 http://blog.csdn.net/lsong89/article/details/8598856 
 * Thank you very much 
 */ 
public class MainActivity extends Activity { 
	private ListView mListView; 
	private ListViewAdapter mListViewAdapter; 
	private ArrayList<ArrayList<HashMap<String,Object>>> mArrayList; 
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		init(); 
	} 
	private void init(){ 
		mListView=(ListView) findViewById(R.id.listView); 
		initData(); 
		mListViewAdapter=new ListViewAdapter(mArrayList, MainActivity.this); 
		mListView.setAdapter(mListViewAdapter); 
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "mListView-->setOnItemClickListener", Toast.LENGTH_SHORT).show();
			}
		});
	} 
	private void initData(){ 
		mArrayList=new ArrayList<ArrayList<HashMap<String,Object>>>(); 
		HashMap<String, Object> hashMap=null; 
		ArrayList<HashMap<String,Object>> arrayListForEveryGridView; 

		for (int i = 0; i < 10; i++) { 
			arrayListForEveryGridView=new ArrayList<HashMap<String,Object>>(); 
			for (int j = 0; j < 5; j++) { 
				hashMap=new HashMap<String, Object>(); 
				hashMap.put("content", "i="+i+" ,j="+j); 
				arrayListForEveryGridView.add(hashMap); 
			} 
			mArrayList.add(arrayListForEveryGridView); 
		} 

	} 
} 