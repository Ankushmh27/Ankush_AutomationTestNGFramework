package javaProgram;

import javax.management.remote.SubjectDelegationPermission;

public class ChildClass extends LogicalProgram
{
	String name="Manoj";
	
	
	public static void main(String[] args) {
	
		ChildClass cl = new ChildClass();
		cl.child();
		cl.Qualification();
		
	}
public  void child() 
{
	System.out.println(super.name);
	super.Qualification();
}
public void Qualification() 
{
	String study="10";
	System.out.println(study);
}
}
