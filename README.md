# CACAMUCA 까까무까
## 🍪 1. 프로젝트 소개

**CACAMUCA는 전세계의 과자를 리뷰하는 사이트입니다!!**
### 1-1. 프로젝트 노션
<img width="1194" alt="image" src="https://github.com/goalapa/spring-cacamuca/assets/61495627/b8e6f8c7-a477-4132-880e-cc89b523dd52">

* 노션 링크 : https://www.notion.so/hammang/Goal-apa-3662c97974f54b93b62adf62e506bf38


<br>

## 👋 2. 팀원 소개
<table>
  <tr>
    <td align="center"><a href="https://github.com/bbbbooo"><img src="https://avatars.githubusercontent.com/bbbbooo" width="150px;" alt="">
    <td align="center"><a href="https://github.com/Dylan-SonJungin"><img src="https://avatars.githubusercontent.com/Dylan-SonJungin" width="150px;" alt="">
    <td align="center"><a href="https://github.com/juunewon"><img src="https://avatars.githubusercontent.com/juunewon" width="150px;" alt="">
    <td align="center"><a href="https://github.com/numerical43"><img src="https://avatars.githubusercontent.com/numerical43" width="150px;" alt="">
    <td align="center"><a href="https://github.com/myrhymetree"><img src="https://avatars.githubusercontent.com/myrhymetree" width="150px;" alt="">
    </td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/bbbbooo"><b>이현석</b></td>
    <td align="center"><a href="https://github.com/Dylan-SonJungin"><b>손정인</b></td>
    <td align="center"><a href="https://github.com/juunewon"><b>이주원</b></td>
    <td align="center"><a href="https://github.com/numerical43"><b>강수의</b></td>
    <td align="center"><a href="https://github.com/myrhymetree"><b>박성준</b></td>
  </tr>

  <tr>
    <td align="center">Lee Hyeon Seok</td>
    <td align="center">Son Jung In</td>
    <td align="center">Yi Ju Won</td>
    <td align="center">Kang Su Ui</td>
    <td align="center">Park Seong Joon</td>
  </tr>
    <tr>
    <td align="center"><strong>리뷰, 좋아요 기능</strong></td>
    <td align="center"><strong>통계, 요청 기능</strong></td>
    <td align="center"><strong>카테고리, 식품 기능</strong></td>
    <td align="center"><strong>신고, 블랙리스트 기능</strong></td>
    <td align="center"><strong>회원, 로그인 기능</strong></td>
  </tr>
</table>

<br>

## ⚒️ 3. 기술 스택
![image](https://github.com/goalapa/spring-cacamuca/assets/61495627/410c86db-5ee4-4ee0-a804-a9a0b7911a85)

<br>


## 🧱 4. 프로젝트 아키텍처
### 4-1. CONTEXT MAP
![image](https://github.com/goalapa/spring-cacamuca/assets/61495627/1083d5fd-9e89-4b0c-8652-0d85466c5024)

<br>

## 🗒️ 5. 요구 사항
- 기능별로 각각의 상황을 테스트하는 코드를 구현한다.
- 새로운 기능, 버그 fix 등의 코드 수정이 있다면 이슈를 작성한다.

<br>

## 📌 6. 기능 소개
### 6-1. 메인 화면
    - 대표 나라 5개 (한국, 일본, 미국, 대만, 베트남)의 전날 top10을 볼 수 있다.
      - top 10은 전날 생성된 리뷰와 별점을 기준으로 스케줄러를 통해 통계를 낸다.
    - top 10의 과자를 선택하면 해당 식품의 리뷰들을 볼 수 있다.
    - 검색 기능을 통해 원하는 과자를 검색할 수 있다. 
    - 내비게이션 바의 나라를 클릭하여 해당 나라의 식품들을 볼 수 있다.
### 6-2. 리뷰
    - 식품에 대한 리뷰를 작성할 수 있다. 
      - 리뷰에는 별점, 키워드, 리뷰 내용, 가격, 사진을 입력할 수 있다.
    - 식품에서 본인이 작성한 리뷰를 볼 수 있다.
    - 리뷰에는 작성자, 내용, 리뷰 사진, 좋아요가 표시된다.
    - 리뷰에는 좋아요를 클릭할 수 있으며, 다시 한 번 클릭하면 좋아요가 취소된다.
### 6-3. 회원 가입
    - 아이디, 비밀번호, 닉네임, 이메일, 국적, 성별, 생년월일을 입력하여 회원가입할 수 있다.
      - 아이디와 이메일은 기존 회원과 중복될 수 없다.
      - 비밀번호는 비밀번호 확인을 함께 받아 일치하는지 확인한다.
      - 생년월일은 회원가입 날짜 이후가 될 수 없다.
### 6-4. 아이디/비밀번호 찾기
    - 이메일을 입력하면 해당 이메일로 아이디 정보가 전송된다.
    - 아이디를 입력하면 아이디와 함께 저장된 이메일로 임시 비밀번호가 전송된다.
### 6-5. 식품 요청하기
    - 원하는 과자/식품이 없다면 요청하기를 통해 과자를 등록할 수 있다. 
    - 원하는 식품의 이름, 나라, 카테고리, 사진, 내용을 입력하여 요청할 수 있다.
### 6-6. 마이페이지
    - 국적, 비밀번호, 이메일과 같은 회원정보를 수정할 수 있다.
    - 내가 작성한 모든 리뷰를 볼 수 있고, 수정과 삭제가 가능하다.
    - 사이트에 대한 사용자 평가를 작성할 수 있다.
    - 회원 탈퇴를 할 수 있다. 
### 6-7. 신고
    - 누적 신고 횟수가 일정 수치를 초과하면 해당 리뷰는 삭제된다.
    - 리뷰가 신고될 때 사용자도 함께 신고되며, 사용자 또한 누적 신고 횟수가 일정 수치를 초과하면 블랙리스트에 오르게 된다.
### 6-8. 관리자 기능 : 통계, 식품/카테고리 관리, 블랙리스트 관리
    - 회원의 전체 목록을 볼 수 있다. 
      - 회원 목록은 항목에 따라 정렬이 가능하다.
    - 신고 내역을 볼 수 있다. 
      - 신고자, 피신고자, 신고 유형등의 내용을 볼 수 있으며 신고를 수락하거나 반려할 수 있다.
    - 블랙리스트 내역을 볼 수 있다. 
      -이전에 블랙리스트였던 회원 정보도 볼 수 있으며, 관리자가 직접 블랙리스트를 해제할 수 있다.
    - 식품 요청의 전체 목록을 볼 수 있다. 
      - 상세보기를 통해 내용을 확인할 수 있고, 관리자 내용을 보완하여 식품을 등록할 수 있다.
    - 카테고리 목록을 볼 수 있다. 
    - 특정 날짜와 나라에 따른 식품 통계를 볼 수 있다. 
      - 좋아요, 리뷰 수가 항목으로 포함되며, 해당 날짜의 top 10 목록도 따로 조회할 수 있다.
    - 통계는 상세보기를 통해 시각적인 통계자료를 볼 수 있다.
    - 사용자 평가를 볼 수 있다. 사용자 평가로 받은 별점의 평균을 볼 수 있다. 

-----------------------------------

#### 📝 Project Rules
* Issue가 생기면 Repository의 Issues에 기록하기
* main branch에 바로 push 금지! develop branch로 Pull requests 하기
* git convention을 지키기
* pr 전에 이슈 발행 필수, pr 할 때 이슈 번호 입력 필수!
* 이슈 하나는 본인이 하루 내에 해결할 수 있는 양으로 선정하기
* pr에 모든 사람이 코드 리뷰 남기기 (LGTM 금지🙅)

#### 🏷️ Git Convention
| **Convention**  | **내용**                                                         |
|-----------------|----------------------------------------------------------------|
| **Feat**        | 새로운 기능 추가                                                      |
| **BugFix**         | 버그 수정                                                          |
| **Test**        | 테스트 코드, 리펙토링 테스트 코드 추가, Production Code(실제로 사용하는 코드) 변경 없음     |
| **Comment**     | 필요한 주석 추가 및 변경                                                 |
| **Rename**      | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우                                   |
| **Remove**      | 파일을 삭제하는 작업만 수행한 경우                                            |
| **Design**      | CSS 등 사용자 UI 디자인 변경                                            |
| **Refactor** | 프로덕션 코드 리팩토링                                                   |

---------------------------------------------------
