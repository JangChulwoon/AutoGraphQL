#### Linux command 

> 생각보다 Linux command 를 아는게 없어서, 몇가지 명령들을 정리해볼까한다. 

오늘은 `cp / mv / rm / ln` 에 대해 학습했다. 

#### cp  파일/ 디렉터리 복사

특정 파일 / 디렉터리를 복사하는 command. 

```aidl
touch copyFile.txt
echo "hello"  > originFile.txt

cp originFile.txt copeFile.txt 
```

파일인 경우 파일 내용들이 복사되고, Directory 인 경우 폴더들이 복사된다. 

> Directory 예시 

```aidl
mkdir origin
mv *File.txt origin 
mkdir copyDirectory

cp origin/* copyDirectory 
## Origin 폴더 내부 파일들을 복사해야하기에 위처럼 와일드 카드를 써줘야한다. 

# or 

cp -r origin copyDirectory 

# copyDirectory 안에 origin 을 모두 가져오고 내부 폴더까지 복사한다. 


(chage any file in copyDirectory .. )

cp -u origin/* copyDirectory 

# 새로 생기거나, 가장 최근 수정된 파일들을 붙여넣는다. 
```

생각보다 `cp`가 유용할 듯 함.

> 기억해야할것 -r / -u 


#### mv 옵션 

파일을 옮기거나 파일명을 수정할 때 사용된다.

cp 와 마찬가지로 `-u` 를 사용할 수 있다.


```aidl
mv -u *File.txt origin 
```


#### rm 

요건 간단하니까 패스 

```aidl
rm -rf something
```

> 삭제하면 복구 불가하니 조심스럽게 사용할 것. 



#### Link 

Link 는 2가지가 존재하는데, `symbolic link` / `hard link` 가 있다.

> hard link 

파일을 가르키는 포인터를 하나 더 만드는 것.

> 수정시, 모든 파일이 수정된다.

파일이 모두 지워지기 위해선, 하드링크로 연결된 파일들이 모두 삭제되어야한다.

```aidl

ln file1 file2 

```

hard link를 directory 에 사용하는 경우, 무한 루프 tree 형태를 생성할 수 있으므로, 피하는것이 좋다.


```aidl

-rw-r--r--  1 jangcheol-un  staff     9B Jan  1 13:20 1
-rw-r--r--  2 jangcheol-un  staff     9B Jan  1 13:20 file1
-rw-r--r--  1 jangcheol-un  staff    15B Jan  1 11:56 file2
-rw-r--r--  1 jangcheol-un  staff     0B Jan  1 11:57 file3
-rw-r--r--  1 jangcheol-un  staff     0B Jan  1 11:57 file4
-rw-r--r--  2 jangcheol-un  staff     9B Jan  1 13:20 file5
```

접근 권한 옆의 숫자가 hard link 수를 의미하는 듯 함.

> ls -i 사용시, node num 을 볼 수 있는데 이게 같으면 같은 링크라는 의미 

#### symbolic link

하드링크와는 달리, 원본 파일을 가리키고 있는 구조.

 ```aidl
 
 ln -s file1 file2 
 
 ```
 
 file1 (`origin file`)이 삭제될 경우, 링크가 깨지면서 참조할 수 없다. 
 
 
보통 서버 설정파일들을 workspace folder 에 링크(`sybolic`)를 걸어 사용한다.
 
 
 
#### 여담 

명령어들의 옵션들을 보고 싶을땐, `man 명령어`로 확인하는게 좋다. 


2019 01.01 
TIL 
 