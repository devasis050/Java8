package defalultmethod;

public interface Interface1 {
	
	default void default1()
	{
		Interface1.this.default1();
		System.out.println("Defalult1 in I1");
	}

}
