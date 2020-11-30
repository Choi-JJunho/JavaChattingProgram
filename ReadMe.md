# 자바 채팅 프로그래밍
-  저자 : 안용화출판 : 구민사

![img](https://lh3.googleusercontent.com/o23ryh16hSUFauzreVRSO7w6x9ccCaarF74Av5fg7SkZFietxLoJx99PgI8UPybLCwTWgiEIoYZpJvhRh1PsvbS_fVg0ClgVZ9J61ik3g2Hlu_m1amlJmvXHbIZcv6m2CdOBe1YN)

## 서론

동방에 있던 책이 재밌어보여서 들고왔다.
총 13챕터로 구성되어있으며 매주 2챕터씩 총 7주차에 거쳐 읽을 생각이다.

## 01. 바이트 입출력 스트림

전체적으로 데이터의 입/출력이 일어날 때 바이트단위로 데이터를 다루게 되는 I/O 클래스들을 소개하고있다.

**Stream** : 순서가 있는 일련의 데이터를 의미하는 추상적인 개념이다.

하드 -> 메모리로 데이터를 읽어들일 때 과정( 하드와 메모리 사이 채널 형성 -> 데이터가 채널을 통해 전달 )이렇게 형성된 채널을 통해 일련의 데이터가 흘러가거나 흘러오는것을 스트림이라고 이해하면 편하다.

**flush()** : 버퍼의 내용이 채워지지 않아도 강제적으로 버퍼의 내용을 **전송**하는 기능을 한다.

> C언어에서 `fflush()`를 입력버퍼를 비워준다로 이해하고있던 개념에 무언가 잘못된듯 싶었다. 내용을 전송하는것과 비우는것은 혼동해선 안될 개념이기 때문이다.
> 마침 구글링해보니 같은 고민을 한 사람이 있었다. [참고](https://m.blog.naver.com/PostView.nhn?blogId=klh1514&logNo=120190269672&proxyReferer=https:%2F%2Fwww.google.com%2F) [참고2](https://okky.kr/article/97122) 

> > 파일을 스트림으로 전송할 경우 I/O 횟수를 줄이기 위해 버퍼에 쌓았다가, 버퍼에 데이터가 쌓이면 한꺼번에 보내기 때문에 `flush()` 메소드가 해당 역할을 한다고 한다.
> > 아래 InputStream클래스의 설명을 보면 더 납득될 것이다.
> > InputStream : 파일이나 다른 컴퓨터로부터 **바이트 데이터를 읽어서 메모리로 저장**하는 기능을 제공하는 기본적인 메소드들을 지원한다.

```java
protected FilterOutputStream(OutputStream out)protected FilterInputStream(InputStream in)
```



## 02. 필터 입출력 스트림

### Filter IO Stream

바이트 스트림 위에 부가적인 기능을 제공하는 필터 스트림에 대해 설명한다.
FileInputStream, FileOutputStream 클래스와 같이 바이트 단위로 데이터를 전송하는 기능을 수행하는 클래스들을 **기반(underlying) 입출력 스트림 클래스**라고 한다.
이러한 기반 스트림에 연결하여 바이트 데이터가 아닌 문자, 정수, 실수 등과 같은 데이터를 직접 전송할 수 있는 기능을 추가한 클래스들을 **필터 입출력 클래스**라 한다.

필터 클래스의 객체에 데이터를 전송하면 연결된 기반 스트림을 통하여 목적지에 데이터가 전송된다.

FileIOStream, FilterIOStream과 같은 기반 스트림 클래스들은 한번에 한 바이트씩 데이터를 전송한다. 때문에 4바이트인 정수를 전송하기 위해서는 4번의 write()가 수행되어야한다.

이렇게 자료형 별로 데이터를 전송이 필요한 경우를 위해 FilterOutput(Input)Stream의 하위 클래스인 DataOutput(Input)Stream 클래스가 존재한다.

실제로 데이터를 집어넣었을 때 해당 데이터를 메모장으로 보려고하면 byte로 저장된 데이터이기 때문에 당연히 깨져보인다.

DataOutputStream으로 읽어들이면 정상적으로 다시 읽을 수 있다.

![img](https://lh6.googleusercontent.com/S0Jdwhv_pIzPTL2jZq45TVbogxGNHIErAdkfhZEoDQP4ung7qMB2-kK8qbvQglmKfG9dM-rvSDOHUmi46nifPXzSoXZR2KV4eLZQn-ZH_3Vv4u1qtAV_atP8WbmilZtUdPttdI9f)

![image-20201106162013770](https://lh5.googleusercontent.com/yp2gTQQg4t0bh_9Y1Rhg5uBCbKNjtcuIhcciHYFR-9AvARLEVDyObYvhzpkgqd7n7XMVOKr3jxbEwEdKxQamaC8Dcn7A6h04sZOiDWvnePOA32NPQDO_95N43QELOVLQk8I76uGt)

---



### Buffered IO Stream

FileOutputStream 기반스트림의 write() 메소드는 수행문을 실행할 때 마다 전송할 데이터를 스트림에 전송한다. 이는 즉 100바이트를 전송하면 스트림에 100번을 전송하기 때문에 매우 비효율적이라고 볼 수 있다.

따라서 스트림에 데이터를 보내기 전에 일정한 데이터를 보관했다 한번에 보내는 BufferedOutput(Input)Stream을 사용할 수 있다.

BufferedIOStream은 **버퍼가 꽉 차면** 스트림에 한번에 데이터를 전송하는 기능을 수행한다.

버퍼가 다 차지 않았을 경우에는 버퍼에 있는 데이터를 강제적으로 스트림에 전송하게 하는 flush() 메소드를 사용할 수 있다. 따라서 BufferedOutputStream 클래스를 이용하는 경우는 반드시 write() 메소드 다음에 flush() 메소드를 사용해야한다.

1챕터에서 설명된 flush()가 버퍼를 전송한다는 것이 조금은 그럴싸하게 생각된다.

PushbackInputStream 클래스는 데이터의 unreading 기능을 지원한다.read() 메소드에 의하여 스트림으로부터 읽은 데이터를 unread(int b) 메소드에 의해 입력스트림으로 다시 전송하여, 다음 read() 메소드가 일기를 수행할 때 다시 읽혀질 수 있게한다.

```java 
PushbackInputStream pinput = new PushbackInputStream(InputStream in);
int data = pinput.read();
pinput.unread(data);
int data = pinput.read();
```

---



## 03. 파일처리 클래스

Windows, Unix의 파일 접근 구분자는 서로 다르다.

Windows의 경우 C:\, Unix의 경우 / 로 구분하게된다.

파일 경로를 잡을 때 하나의 프로그램이 OS별로 다르게 동작하게 된다면 골치아플 것이다.

JAVA에서 파일처리를 할 때는 이러한 문제를 해결해준다.



기존의 FileIOStream으로 파일을 읽을 때는 순차적으로 데이터를 읽기 때문에 중간이나 끝에 있는 데이터를 찾을 때 시간이 많이 소요된다. C나 CPP에서 파일 입출력을 수행할때와 마찬가지로 파일 포인터를 통해서 임의 접근을 할 수 있다.

```java
public RandomAccessFile(String name, String mode) throws FileNotFoundException
```

name : 파일/폴더의 이름

mode : "r" (읽기모드), "rw" (읽기/쓰기 모드)

기존에 C에서 다룬 방법과 한가지 차이가있다면 java에서는 "w"(쓰기모드)를 지원하지 않는다.



작성한 WriteRandomFile.java 에서 파일을 저장할 때 binary형식으로 저장하기 때문에 에디터로 확인하기 어렵다.

때문에 `Record` 클래스에 생성해둔 read() 메소드를 사용해야한다.



추가로 자바는 열려진 모든 파일에 대해 FileDescriptor를 생성하며 이 객체는 실제 파일에 대한 참조자나 파일 내에서 읽기/쓰기 위치와 같은 정보들을 포함하고 있다.

---

## 04. 문자 입출력 스트림

자바는 기본적으로 모든 문자집합에대해 16비트로 구성된 유니코드르 사용한다.

문자 입출력 스트림클래스로는 크게 Reader, Writer로 나누어 볼 수 있다.

이는 각각 InputStream, OutputStream과 대응된다.



Writer 클래스 (추상메소드) : 문자 배열 text의 offset 위치에 있는 문자부터 length개의 문자를 전송한다.

```java
public abstract void wirte(char[] text, int offset, int length) throws IOException
```



Reader 클래스 (추상메소드) : 스트림으로부터 최대 length 개의 문자를 읽어 buffer 문자 배열의 offsetdㅟ치부터 저장하고 읽은 문자의 수를 반환한다.

```java
public abstract int read(char[] buffer, int offset, int lenght) throws IOException
```

---



### BufferWriter / BufferReader

기본적인 Writer 및 Reader 객체에 버퍼를 추가하여 전송 속도를 증가시킨다.



### OutputStreamWriter / InputStreamWriter

```java
public OutputSteramWriter(OutputStream out, String encoding) throws UnsupportedEncodingException
```

out에 연결하고 encoding으로 명시된 방식으로 문자를 인코딩하는 OutputStreamWriter객체를 생성한다.

사용자가 특별한 인코딩 방식을 지정할 수 있으므로 네트워크 애플리케이션에 적합하다고 볼 수 있다.



