# todo-list

# 목차
  [0. 목차](#목차)  
  [1. 기술 스택](#기술-스택)  
  [2. 동작 시니리오](#동작-시니리오)  
  [3. 어려웠던 점](#어려웠던-점)  
  [4. 새로 알게 된 점](#새로-알게-된-점)  
  [5. 실행 화면](#실행화면)  
  [6. 리팩토링](#리팩토링)  
  [7. 참고](#참고)  

# 기술 스택
  - Front end
    - html
    - css
    - javascript
  - Back end
    - java
    - servlet
    - jsp
  - DBMS
    - mysql
  - Build tool
    - maven

# 동작 시니리오
  - MainServlet : DB에 있는 데이터를 읽어와 index.jsp에 넘겨주는 역할.
  - 새로운 Todo 등록 버튼을 누르면 연결된 URL을 통해서 TodoFormServlet이 실행된다.
  - TodoFormServlet : 새로운 TODO 등록 버튼을 누르면 form.jsp 화면으로 foword 한다.
  - 이전 버튼 : 현재 페이지 이전으로 이동
  - 제출 버튼을 누르면 Form에 입력된 데이터들이 POST방식을 통해 서버에 전달 된다.
  - 내용비우기 버튼 : Form에 입력된 내용을 초기화한다.
  - TodoAddServlet : 사용자로부터 수신 받은 데이터를 DB에 저장한다.
  - TodoTypeSevlet : 각 Todo에 달려있는 상태변경버튼(->)을 누르면 해당하는 type으로 변경해 DB에 저장한다.

# 어려웠던 점
  - html태그와 css로 화면만드는 일이 머릿속 이미지와 실행 결과물의 차이가 너무 컸다.
  - front end 오타 찾기와 디버깅

# 새로 알게 된 점
  - db에 저장하다가 한글이 깨지길래 db charset을 확인 해봤는데 utf-8로 잘 되있는데 왜 계속 깨지나 생각해본 결과,
  Servlet에서 문자 인코딩이 달랐다. 그래서 문자열 인코딩 바꿔주니 잘 동작 됐다.
  - html tag button에 class속성을 주니 인식을 못하는거 같다. 일단 id로 바꿈 

# 실행화면
![](https://user-images.githubusercontent.com/52232390/60170484-7aae8800-9843-11e9-95f6-8cb37d01bb72.png)
![](https://user-images.githubusercontent.com/52232390/60170490-7c784b80-9843-11e9-8224-23d3b0923279.png)
![](https://user-images.githubusercontent.com/52232390/60170503-7f733c00-9843-11e9-89ed-62873f8eab7f.png)
![](https://user-images.githubusercontent.com/52232390/60170507-813cff80-9843-11e9-8510-7a330e05d1b7.png)

# 리팩토링
  - AJAX를 적용해야한다는데 나는 왜 안썻지?
  - ~~중복되는 코드들 없애기~~
  - ~~하드코딩된 부분 없애기~~
  - ~~jsp를 el, jstl적용 해보기~~
# 참고
https://www.edwith.org/boostcourse-web/project/7/content/6#summary
