## Objectives
in this practical work the goal was to work with the socket, and to understand how to send through the stream the integer or the strings, using classes and interfaces like `InputStream`, `OutputStream`, `BufferReader`, `PrintWriter` and other, as well as working with threads and stream at the same time.
## Ex 1
#### server
- we create a random variable with Math class which will be the number that the clients will be searching for.
```java  
public static int goal = (int)(Math.random()*100);
```
- we start by creating the server and wait until a client build a connection, and where we build it we start a thread to handle the communications of that specific client in another class called `Communicator`
```java
ServerSocket ss = new ServerSocket(8000);
Socket s;  
while(true) {  
    s = ss.accept();  
    new Thread(new Communicator(s)).start();  
}
```
- in the run method of `Communicator` we initialize first the necessary objects for communication such as: 
- `InputStream`, `InputStreamReader`, `BufferedReader` to receiving the string sent by client.
- `OutputStream`, `PrintWriter` to send the string to the client.
```java
@Override  
public void run() {  
    InputStream is = s.getInputStream();  
	InputStreamReader isr = new InputStreamReader(is);  
	BufferedReader br = new BufferedReader(isr);  

	OutputStream os = s.getOutputStream();  
	PrintWriter pw = new PrintWriter(os, true);  

	while(true){  
		value = Integer.valueOf(br.readLine());  
		if(value > Main.goal) {  
			pw.println("less");  
		} else if(value < Main.goal) {  
			pw.println("more");  
		} else {  
			pw.println("someone won");  
		}  
	}  
}
```
- as a result of the code the server will send instructions to the client until he catch the goal number.
#### client
- in the client we start by building the connection with the server by providing the server name and the port
```java
Socket s = new Socket("127.0.0.1", 8000);
```
- we initialize the communication object again
```java
InputStream is = s.getInputStream();  
InputStreamReader isr = new InputStreamReader(is);  
BufferedReader br = new BufferedReader(isr);    
OutputStream os = s.getOutputStream();  
PrintWriter pw = new PrintWriter(os, true);
```
- and we use a while loop to iterate until we catch the proper value
```java
do {
    int guess = scanner.nextInt();
    pw.println(guess);
    result = br.readLine();
    System.out.println(result);
} while(result.equals("more") || result.equals("less"));
```
## Ex 2
- first we launch the server
```java
ServerSocket ss = new ServerSocket(8000);
```
- when we catch a new connection we start a thread of the class `ServerThread`
```java
while(true) {  
    s = ss.accept();  
    System.out.println("a new client has connected!");  
    ServerThread st = new ServerThread(s);  
    new Thread(st).start();  
}
```
- in `ServerThread` run method we follow the following scheme :
	- initialize communication object
	- read the requested filename from the client
	- load the content of the file
	- send the content to the client
```java  
// initialize the receiving elements
is = s.getInputStream();  
isr = new InputStreamReader(is);  
br = new BufferedReader(isr);  
  
// initialize the sending elements  
os = s.getOutputStream();  
pw = new PrintWriter(os, true);  
  
// read what the client has sent  
String filename = br.readLine();  
  
// initialize the file elements  
File file = new File("src\\main\\java\\org\\example\\EX2\\"+filename+".txt");  
FileReader fileReader = new FileReader(file);  
BufferedReader bufferedReaderForFile = new BufferedReader(fileReader);  
  
// get the content of the file  
String contentFile = bufferedReaderForFile.readLine();  
  
// send the content  
pw.println(contentFile);
```
- for the client :
	- we build the connection
	- initialize the stream objects
	- write the targeted filename
	- read after receiving, the content of the file
```java
Socket s = new Socket("127.0.0.1",8000);  
  
InputStream is = s.getInputStream();  
InputStreamReader isr = new InputStreamReader(is);  
BufferedReader br = new BufferedReader(isr);  
  
OutputStream os = s.getOutputStream();  
PrintWriter fw = new PrintWriter(os,true);  
  
Scanner scanner = new Scanner(System.in);  
  
System.out.println("write the filename that you need to read it's content :");  
  
fw.println(scanner.nextLine());  
  
String receivedContent = br.readLine();  
  
System.out.println("the received content is : "+receivedContent);
```
- end