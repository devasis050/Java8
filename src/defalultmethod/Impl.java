package defalultmethod;

import java.util.Set;

public class Impl implements Interface1, Interface2{
	@Override
	public void default1() {
		Interface1.super.default1();
	}
}
