package acc.projman.springExamples;

public class Car {
	Engine e;
	Door d;
	Tires t;
	
	public Car(Engine e, Door d, Tires t) {
		super();
		this.e = e;
		this.d = d;
		this.t = t;
	}
	
	public void printCarDetails() {
		System.out.print(this.e+" "+this.d);
	}
	
}
