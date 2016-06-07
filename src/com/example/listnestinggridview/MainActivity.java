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
 * Demo描述: 
 * ListView嵌套GridView使用详解 
 * 即ListView的每个Item中都包含一个GridView 
 * 
 * 注意事项: 
 * 由于ListView和GridView都是可滑动的控件. 
 * 所以需要自定义GridView,重写其onMeasure()方法. 
 * 在该方法中使GridView的高为wrap_content的大小,否则GridView中 
 * 的内容只能显示很小一部分 
 * 
 * 参考资料: 
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