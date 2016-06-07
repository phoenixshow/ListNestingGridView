package com.example.listnestinggridview;

import android.content.Context; 
import android.util.AttributeSet; 
import android.widget.GridView; 
public class NoScrollGridView extends GridView { 
	public NoScrollGridView(Context context) { 
		super(context); 

	} 
	public NoScrollGridView(Context context, AttributeSet attrs) { 
		super(context, attrs); 
	} 

	/**
	 * ���ò����� 
	 * ����onMeasure���������������ʾ�ĸ߶����ȣ�
	 * makeMeasureSpec�����е�һ�������������ֿռ�Ĵ�С���ڶ��������ǲ���ģʽ
	 * MeasureSpec.AT_MOST����˼�����ӿؼ���Ҫ���Ŀռ����չ�����Ŀռ�
	 * ͬ���ĵ���ListViewҲ����
	 */
	@Override 
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST); 
		super.onMeasure(widthMeasureSpec, expandSpec); 
	} 
} 