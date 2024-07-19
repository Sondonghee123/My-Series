# 📽나만의 시리즈(My Series)

신한 DS 금융 SW 아카데미 JDBC Project

#### 📙 발표자료([Click]()

## 💡프로젝트 소개

기억에 남는 미디어들을 잊지 않기 위한 저장소

### 프로젝트 목적

#### 1) DataBase

저장하고자 하는 미디어들을 Oracle을 이용하여 데이터베이스의 CRUD 기능을 구현한다.
  
#### 2) User Interface

웹에서의 사용자 편의성을 고려하여 예외처리 및 인터페이스 간단화


## ✏ERD
![image](https://github.com/user-attachments/assets/97b609e8-34c9-4951-ae77-b7416fc91c74)

## ✏User Flow
![image](https://github.com/user-attachments/assets/84af83e4-53df-4c18-8987-bb8333681142)


## 📝주요 기능

### 1. Create 데이터 삽입 (Insert)

- #### 회원가입
![image](https://github.com/user-attachments/assets/a06cd766-b82a-439f-9ad6-d02955546391)
<br>각각 제약조건에 맞게 입력 시 회원가입 가능

- #### 미디어 저장
![image](https://github.com/user-attachments/assets/5d248fcd-e0f4-4bf1-bbd6-ece75e2a44f2)
<br>내용 입력 후 저장버 버튼 클릭 시

![image](https://github.com/user-attachments/assets/31b81b91-f243-4584-b1c4-3db6a66b8cc2)
<br>해당 내용의 카드가 추가됨


### 2. Read 데이터 조회 (Select)

- #### 로그인
![image](https://github.com/user-attachments/assets/c5da8621-913c-4d12-b41e-6542b840665a)
![image](https://github.com/user-attachments/assets/7bb31268-33cd-4ea7-bd88-648e64cf3b0d)
User 테이블에 있는 데이터와 일치할 경우 로그인 성공

- #### 미디어 검색
![image](https://github.com/user-attachments/assets/345d0493-35ae-4008-b284-b9d9f65da297)
<br>제목, 올린사람, 별점으로 검색 가능


### 3. Update 데이터 수정 (Update)

- #### 미디어 정보 수정
![image](https://github.com/user-attachments/assets/4fc985ec-5a89-42ff-aa61-98e6bef3d05d)
![image](https://github.com/user-attachments/assets/3910355c-3556-42be-9b46-f3763e98bdee)
기존에 추가했던 미디어 정보 수정

![image](https://github.com/user-attachments/assets/54ff8e29-a922-495d-bbd3-19cbdf99d373)
수정 완료


### 4. Delete 데이터 삭제 (Delete)

- #### 미디어 삭제
![image](https://github.com/user-attachments/assets/4d51917b-564a-47ca-b69e-b5cd5eda2446)
삭제 버튼 클릭 시
![image](https://github.com/user-attachments/assets/0d903a6c-65dc-4d77-b6be-a9f4e2876423)


![image](https://github.com/user-attachments/assets/b8efce08-e505-4984-b856-1df24ce4cea4)
제거 완료


## 📑추가 기능

### 1. Generate Chat name

<table>
        <tbody>
            <tr>
                <td align="center"><b>Chat</b></td>
                <td align="center"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/6ea8a136-aa04-4b79-b894-e539b52142d9"></td>
                <td align="center"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/2b1d7407-5754-4151-958e-8d263ee9a98f"></td>
            </tr>
            <tr>
                <td align="center"><b>name</b></td>
                <td align="center">null</td>
                <td align="center">"Request for Lunch Recommendation and Curry Recipe Instructions"</td>
            </tr>
        </tbody>
    </table>

대화 종료시 GPT를 이용하여 자동으로 대화 내용에서 제목을 만들어 채팅방 이름으로 사용.

### 2. Stream

<table>
        <tbody>
            <tr>
                <td align="center"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/383e76d5-eb5e-417e-b1cf-9d9c8e173e4e"></td>
                <td align="center"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/976e997f-bb91-4115-a547-381919ed42b7"></td>
            </tr>
            <tr>
                <td align="center">Stream off</td>
                <td align="center">Stream on</td>
            </tr>
        </tbody>
    </table>

빠른 답변 확인과 유저 경험을 개선하기 위한 Stream 기능을 추가하였다. 

다만 Stream을 사용할 시 OpenAI api의 response에 usage tokens에 관한 정보를 주지 않기 때문에 토큰을 활용한 summary기능의 사용이 제한되었다.


## Service Logic
<img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/9ef4113d-61de-4613-8fd5-82767e83e0c7" width="90%">

## ERD
<img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/848e77b6-0a2c-43d0-b0c5-f9d9cd9982c5" width="90%">

## ⚙️개선사항

### 1. Cache 기능의 낮은 유연성

현재 cache기능은 db에서 완벽하게 똑같은 질문이 있을시에 작동한다. 하지만 다른 질문이어도 의미가 같은 경우도 있고, 사용자의 오타같은 여러 요인에 대응할 수 있어야 실제 서비스에서 사용할만한 수준이 될 것이다.

### 2. History deps 구현

대화 log가 쌓였을 시 한번씩 Summary를 만들어 token사용량을 줄이고자 history를 만들었다. 하지만 대화가 길어져 summary가 많아진다면 같은 문제가 발생하게 된다. 따라서 history에 deps를 만들어 요약한 내용이 많아지면 또 요약해서 저장하는 식으로 로직을 개선하고자 한다.

<table>
        <tbody>
            <tr>
                <td align="center" width="50%"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/a081a17b-4b7f-4381-85fc-b7541a1fff3b"></td>
                <td align="center" width="50%"><img src="https://github.com/MinkyoDev/efficient-chatbot-use/assets/141614581/0097ff94-2470-4526-bd61-227ef1e83b6d"></td>
            </tr>
            <tr>
                <td align="center">Cache 기능의 낮은 유연성</td>
                <td align="center">History deps 구현</td>
            </tr>
        </tbody>
    </table>

## 4. 💻기술 스택

### Language
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 

### Database
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white)
