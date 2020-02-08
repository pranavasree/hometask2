package com.project;
import java.util.*;
abstract class NewGift{
	abstract int[] takeWeight(int n);
	abstract int[] sort(int[] arr,int n);
}
class App extends NewGift{
	public int[] takeWeight(int n)
	{
		Scanner s1=new Scanner(System.in);
		int gi=n;
		int g[]=new int[gi];
		for(int i=0;i<gi;i++)
		{
			g[i]=s1.nextInt();			
		}
		return g;
	}
	public int[] sort(int arr[],int n)
	{
		int i,t;
		for(i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(arr[i]<arr[j])
			{
				t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
			}
		}
	}
	return arr;
}
	public static void main(String[] args) {
		NewGift ne=new App();
		int n,i,ulimit,llimit;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter total number of  Gifts");
		n=obj.nextInt();
		int gifts[]=new int[n];
		int chocolates[]=new int[n];
		int sweets[]=new int[n];
		System.out.println("Enter upper and lower range");
		ulimit=obj.nextInt();
		llimit=obj.nextInt();
		System.out.println("Enter weights of gifts in the range of "+llimit+","+ulimit);
		gifts=ne.takeWeight(n);
		gifts=ne.sort(gifts,n);
		for(i=0;i<n;i++)
		{
			if(gifts[i]>ulimit || gifts[i] <llimit)
			{
				System.out.println("Weights must be with in the range");
			System.exit(0);
			}
		}
		App g=new Chocolate();
		llimit=gifts[n-1]-60;
		ulimit=gifts[0]-60;
		if(llimit<=0)
		{
			llimit=0;
		}
		if(ulimit<=0)
			ulimit=0;
		System.out.println("Enter weights of chocolates in the range of "+llimit+","+ulimit);
		chocolates=g.takeWeight(n);
		chocolates=g.sort(chocolates,n);
		for(i=0;i<n;i++)
		{
			if(chocolates[i]>ulimit || chocolates[i] <llimit)
			{
				System.out.println("Weights must be with in the range");
			System.exit(0);
			}
		}
		Sweets s=new Sweets();
		sweets=s.takeCandies(gifts,chocolates,n);
		System.out.println("Hence Weights of  Candies are");
		for(i=0;i<n;i++)
		{
			if(sweets[i]<0)
			{
				System.out.println("no space for candies");
			}
			else
				
			System.out.println(sweets[i]);
		}
	}
}
class Chocolate extends App
{
	int chokies;
	Scanner cobj=new Scanner(System.in);
	public int[] takeWeight(int n)
	{
		chokies=n;
		int c[]=new int[chokies];
		for(int i=0;i<chokies;i++)
			c[i]=cobj.nextInt();
		return c;
	}
	public int[] sort(int arr[],int n)
	{
		int i,t;
		for(i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(arr[i]<arr[j])
			{
				t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
			}
		}
	}
	return arr;
}
}
class Sweets extends App{
	public int[] takeCandies(int[] gn,int[] gc,int size)
	{
		int candies[]=new int[size];
		for (int i=0;i<size;i++)
		{
				candies[i]=gn[i]-gc[i];
		}
		return candies;
	}
}