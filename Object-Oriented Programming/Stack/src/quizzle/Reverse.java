package quizzle;

public class Reverse {
	public static <X> IList<X> reverse(IList<X> v, Stack<X> p){
		int n = v.length();
		p = dumpList(v, p);
		v = helper(p, n);
		return v;
	}
	
	public static <X> Stack<X> dumpList(IList<X> dumpee, Stack<X> dumper){
		if (dumpee.isEmpty()){
			return dumper;
		}
		else {
			try {
				return dumpList(dumpee.rest(), dumper.push(dumpee.first()));
			}
			catch(Exception e) {
				System.out.println("Error in dumplist: " + e.getMessage());
				return dumper;
			}
		}
	}
	
	public static <X> IList<X> helper(Stack<X> p, int n){
		if (n == 0) {
			return(new MTLIST<X>());
		}
		else {
			try { 
				return helper(p.pop(), (n - 1)).cons(p.top());
			}
			catch (Exception e) {
				System.out.println("Error in helper: " + e.getMessage());
				return new MTLIST<X>();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
