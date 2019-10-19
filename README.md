테스트 URL
-----
WEB : http://localhost:8080/conversion/form

API : http://localhost:8080/swagger-ui.html

구성
---------------
1. 환경

 * windows 10
 * Spring Tool Suite 4.1.2.RELEASE(build 201902210640)
 * JDK 1.8.0.201

2. 라이브러리

 * spring boot 2.1.9.RELEASE
 * spring framework 5.1.10.RELEASE
 * spring tomcat 2.1.9.RELEASE(scope:provided, tomcat 9.0.26)
 * spring web
 * spring rest
 * spring test(scope:test)
 * spring dev-tools(scope:runtime)
 * lombok 1.18.10
 * jsoup 1.12.1
 * commons-lang3 3.8.1
 * swagger 2.9.2
 * tomcat embed jasper 9.0.26
 * tiles 3.0.8

input
-----
 1. URL
 2. Type
   * `HTML 태그` 제외 (홑화살괄호 포함하여 사이에 있는 글자는 tag 로 간주하여 삭제 함)
   ```
   <html><head><script>alert('#');</script></head><body>Hi</body><html>
  
   문자열에서 HTML 태그 제외 시 
  
   alert('#');Hi
   ```
   * Text 전체
 3. 출력묶음단위(자연수)

rule
-----
 1. 모든문자 입력 (입력항목 : url 기준 파싱된 html | 중국어, 일본어 등이 들어 갈 수 있다.)
 2. 영어, 숫자만 출력
 3. 오름차순 (정렬)
   * 영어 : AaBb...Zz
   * 숫자 : 012...
 4. 교차출력
   * 영어 숫자 영어 ...
```
입력문자 : 金#00AabA12Bba?

rule 1~4의 결과 : A0A0a1a2Bbb
```
5. 출력묶음단위 (기준으로 묶이는 부분이 몫, 묶이지 않는 부분이 나머지)

output example
-----
```
rule 1~4의 결과 : A0A0a1a2Bbb

출력묶음단위 : 3
```
1. 몫 : A0A0a1a2B
2. 나머지 : bb

* `A0A` `0a1` `a2B` 3개의 묶음단위로 묶이므로 몫은 A0A0a1a2B, 남은 bb 는 나머지
