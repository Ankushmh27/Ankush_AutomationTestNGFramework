package javaProgram;

import java.util.jar.Attributes.Name;

import javax.management.remote.SubjectDelegationPermission;

public class LogicalProgram 
{
	String name= "Ankush";
	
	public static void main(String[] args) {
		String name="Hemant";
		System.out.println();
		LogicalProgram logic = new LogicalProgram();
		System.out.println(logic.name+"  global variable calls");
		System.out.println(name+" local variable calls");	
		
	}
	public void Qualification() 
	{
		String study="BE";
		System.out.println(study);
	}

}
