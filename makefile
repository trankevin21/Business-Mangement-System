App.class: App.java
	javac -g App.java
clean:
	rm *.class
run: App.class
	java App
