#### Exception 에 관하여 

JUnit 의 Assert 를 구현하던 중, custom exception 을 구현해야하는 상황이 생겼다.

```java
class Assert{

    public static void assertThat(int actual, int expect){
        if( actual != expect){
            // Have to write try/catch statement!! 
            throw new NotEqualsException("message");
        }
        // success 
    }

    static class NotEqualsException extends  Exception {
        public NotEqualsException(String message){
            super(message);
        }
    }
}



```

위 코드에서 `NotEqualsException` 요 CustomException 을 생성하던 중, `checked Exception` 을 마주하게 되어 관련된 글을 정리한다. 


#### 상속 구조 

`Exception` 과 관련된 클래스들의 상속 구조는 아래와 같다.


```java

class Throwable implements java.io.Serializable {
    
}

class Error extends Throwable{
    
}

class Exception extends Throwable {
    
}

class RuntimeException extends Exception {
    
}

```

최상위 부모 클래스로 `Throwable`, 그 아래로 `Error` , `Exception` 이 존재한다.

```
Error / RuntimeException 은 unchecked Exception
그 외는 checked Exception
```

checked 는 해당 함수를 사용하는 단계에서 `try/ catch or Throws` 코드를 작성해야한다.

예외 처리 종류(?)는 아래와 같다.

> 예외 복구 (retry or transaction ) / 예외 회피 (throws) / 예외 전환 (다른 예외로 ..) 


```
Because "Throwable" is too non-specific. Don't know whether the Java™ Tutorials section is any help.
```

> 만약 Custom Error/ Exception 을 만드는 경우, Error / Exception 을 상속받아야한다. 


Throwable 을 직접 상속하는 것은 좋지 않은 방법이다. 해당 Exception 이 `checked` / `unchecked` 인지 알 수 없을 뿐더러, 어떤 이슈(프로그램 내적 / 외적)로 Exception 이 발생하는지 알 수 없다.

여담으로, Throwable 을 직접 상속하면 checked Exception 으로 취급한다.


#### Error / Exception 


프로그램 내적 이슈는 Exception 을 상속하고, 외적 이슈는 Error 를 상속해야한다.

> 메모리 이슈 / Thread 이슈 상황에서는 Error 를 상속 .. 


Assert 문을 구현하다가, fail 시 checked / unchecked 를 날리는지 궁금해져서 실제 코드를 참고했다.

실제 코드에서는 Error 를 상속하여 fail 을 관리한다. 

> 프로그램 내적 이슈면 RuntimeException 을 날리는게 맞지 않을까 ???  (다 만들어보고 Issue 에 물어봐야겠다.)

난 RuntimeException 으로 관리해야지 ... 




#### 참고 

[RuntimeException vs Error](https://stackoverflow.com/questions/20461688/runtimeexception-error )
