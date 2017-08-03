package com.satisdrms.code.interPrct;

public class ym_Intervene_array {

	public static void main(String[] args) {
		int a1[]={1,2,3,4,5};
		int a2[]={6,7,8,9,10};
	
		int l1=a1.length;
		int l2=a2.length;
		int tot=l1+l2;
		int a3[]=new int[tot];
		int j=0,k=0;
		for (int i=0;i<tot;i++){
			if(j<l1){
				a3[i]=a1[j];
			}
			i++;
			if(k<l2){
				a3[i]=a2[k];
			}
			j++;k++;
		}
		int i=0;
		while(i<tot){
			System.out.println(a3[i]);
			i++;
		}
		
		

	}
}
