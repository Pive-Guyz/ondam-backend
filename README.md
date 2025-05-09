<div align="center">

  # 💕 ON:DAM
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/introduce.png?raw=true" height="500px"/>
</div>

## 👨‍💻 DEVELOPERS
<table>
  <tr>
    <td><img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/member/red.png?raw=true" width="150" height="150"/></td>
    <td><img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/member/green.png?raw=true" width="150" height="150"/></td>
    <td><img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/member/blue.png?raw=true" width="150" height="150"/></td>
    <td><img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/member/yellow.png?raw=true" width="150" height="150"/></td>
    <td><img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/member/pink.png?raw=true" width="150" height="150"/></td>
  </tr>
  <tr>
    <td>:crown:곽우석</td>
    <td>김석희</td>
    <td>서민종</td>
    <td>이상모</td>
    <td>최혜민</td>
  </tr>
</table>
<br><br>

# 🔖 목차

- [💕 ON:DAM](#-ondam)
- [👨‍💻 DEVELOPERS](#-developers)
- [📢 프로젝트 개요](#-프로젝트-개요)
  - [1. 프로젝트 소개](#1-프로젝트-소개)
  - [2. 프로젝트 필요성](#2-프로젝트-필요성)
  - [3. 유사 서비스와 차별점](#3-유사-서비스와-차별점)
  - [4. ON:DAM의 차별화 포인트](#4-ondam의-차별화-포인트)
  - [5. 기대 효과](#5-기대-효과)
- [🛠️ 기술 스택](#️-기술-스택)
- [🪄 시스템 아키텍처](#-시스템-아키텍처)
- [💡 주요 기능](#-주요-기능)
  - [1. 상담 기록 보조](#1-상담-기록-보조)
  - [2. AI 상담 요약 및 감정 분석](#2-ai-상담-요약-및-감정-분석)
  - [3. 감정 흐름 시각화](#3-감정-흐름-시각화)
  - [4. 랜덤 일기](#4-랜덤-일기)
  - [5. 인증된 상담사 전용](#5-인증된-상담사-전용)
- [🙆‍♀️ 요구사항 명세서](#️-요구사항-명세서)
- [📅 WBS](#-wbs)
- [💭 DDD 설계](#-ddd-설계)
- [🗃️ DB 모델링](#️-db-모델링)
- [🖼️ 화면 설계](#️-화면-설계)
  - [UI 설계](#ui-설계)
- [📑 API 명세서](#-api-명세서)
- [🚩 단위 테스트](#-단위-테스트)
- [✍🏻 API TEST](#-api-test)
- [🛜 배포](#-배포)
- [🔜 향후 확장 계획](#-향후-확장-계획)
- [🦄 프로젝트 소감](#-프로젝트-소감)

<br><br>

# 📢 프로젝트 개요

### 1. 프로젝트 소개

**ON:DAM**은 상담사가 상담 내용을 빠르게 기록하고, 내담자의 감정을 AI가 분석하여 시각화해주는 플랫폼입니다.  
상담 내용을 AI에게 전달하면 요약과 감정 흐름 분석이 자동으로 이루어집니다.  
또한, 상담사들끼리 랜덤 일기를 통해 서로 교류하고 정서적 지지를 나눌 수 있습니다.  
내담자의 감정 데이터와 상담 내용을 토대로 더 나은 상담을 이어갈 수 있도록 돕습니다.

### 2. 프로젝트 필요성

- 상담 기록과 정리에 대한 상담사의 부담  
- 내담자의 감정을 객관적으로 파악하기 어려움  
- 상담사 간 교류 부족으로 인한 정서적 소진  
- 상담 기록을 효과적으로 관리하고 활용할 수 있는 시스템 필요

### 3. 유사 서비스와 차별점

| 항목 | <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/Logo/ondam_logo.png?raw=true" width="100"/> <br/>ON:DAM | <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/Logo/mindism_logo.png?raw=true" width="100"/> <br/>마음주의 Hub | <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/Logo/mindiplus_logo.png?raw=true" width="200"/> <br/>마음플러스 |
|------|---------------------------------|-----------------------------|----------------------------|
| 주요 기능 | 상담 기록 요약, 감정 분석, 상담사 간 교류 | 상담 기록 관리, 권한 설정 | 상담 일정 관리, 내담자 관리 |
| 대상 사용자 | 인증된 상담사 | 심리상담사 및 상담센터 | 상담사 및 상담센터 |
| 상담사 지원 | 상담 기록 정리, 감정 분석, 정서적 교류 | 상담 기록 관리, 상담사 권한 설정 | 상담 일정 및 내담자 관리 |
| 감정 분석 | 감정 키워드 기반 분석 및 시각화 | 없음 | 없음 |
| 차별점 | AI 분석 + 상담사 교류 + 정서적 지지 | 권한 관리 중심 | 일정 및 내담자 관리 중심 |

### 4. ON:DAM의 차별화 포인트

- **AI 상담 요약 및 감정 분석**  
  상담 내용을 AI가 자동으로 요약하고 감정을 분석해 내담자의 감정 흐름을 시각화하며, 리포트로 제공해 상담사의 이해와 상담 준비를 지원
  
- **정서적 교류를 위한 랜덤 일기**  
  상담사 간 익명 일기를 통해 서로 자연스럽게 교류하고 정서적 지지를 주고받을 수 있는 기능 제공

- **인증된 상담사만 사용 가능**  
  자격증 확인 절차를 통해 검증된 상담사만 플랫폼을 이용 가능

### 5. 기대 효과

- 상담사의 업무 효율화 및 상담 품질 향상 
- 내담자의 상담 데이터 기반 맞춤형 상담 가능
- 상담사 간 교류를 통한 소진 방지 및 동료 지원 강화
- 상담 데이터 자산화를 통한 서비스 고도화 기반 마련

<br><br>

# 🛠️기술 스택
### FrontEnd
![Vue](https://img.shields.io/badge/Vue%203-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![HTML](https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JSON Server](https://img.shields.io/badge/JSON%20Server-black?style=for-the-badge)

### BackEnd
![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
![SpringBoot](https://img.shields.io/badge/springBoot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### DataBase
![MariaDB](https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white")

### Tool
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white)

<br><br>

# 🪄 시스템 아키텍처
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ProjectArchitecture/ondam_project_architecture.png?raw=true"/>
<br><br>

# 💡 주요 기능

### 1. 상담 기록 보조

- 상담사는 상담 내용을 직접 입력하고 저장할 수 있습니다.  
- 기록된 상담 데이터는 내담자별로 정리되어 상담사가 언제든 쉽게 확인할 수 있습니다.  
- 상담 이력을 통해 상담 흐름을 파악하고, 상담 준비 시간을 줄일 수 있습니다.

### 2. AI 상담 요약 및 감정 분석

- 저장된 상담 기록을 AI가 자동으로 요약합니다.  
- AI는 상담 내용을 바탕으로 감정 키워드를 추출하고 감정을 분석합니다.  
- 분석 결과는 시각화되어 내담자의 감정 흐름을 한눈에 파악할 수 있도록 지원합니다.

### 3. 감정 흐름 시각화

- AI가 분석한 감정 데이터를 차트 형태로 제공합니다.  
- 상담사는 내담자의 상담 과정 중 감정 변화를 쉽게 파악할 수 있습니다.  
- 이를 통해 상담의 방향성을 설정하고 보다 효과적인 상담을 진행할 수 있습니다.

### 4. 랜덤 일기

- 상담사들은 익명으로 일기를 작성할 수 있습니다.  
- 작성된 일기는 무작위로 다른 상담사들에게 전달되어 공감과 답장을 받을 수 있습니다.  
- 이를 통해 상담사 간 자연스러운 정서적 교류와 지지를 경험할 수 있습니다.

### 5. 인증된 상담사 전용

- ON:DAM은 인증된 상담사만 사용할 수 있는 전용 서비스입니다.  
- 자격증 확인 절차를 통해 전문성을 검증합니다.  
- 이를 통해 안전하고 신뢰할 수 있는 상담 환경을 제공합니다.

<br><br>

# 🙆‍♀️ 요구사항 명세서
🔗 <a href="https://docs.google.com/spreadsheets/d/e/2PACX-1vR__7O6DlnXXUGEaxhkK_3oesVtv2Zx80H0IAnnmE2s9OVIhTcCT-D-HdJnyqEubRVIg5wPHXdzKU84/pubhtml?gid=1463868282&single=true"> 요구사항 명세서 자세히 보기</a><br>
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/RequirementSpecification/SRS.png?raw=true" width = "1000"/>

<br><br>

# 📅 WBS
🔗 <a href="https://docs.google.com/spreadsheets/d/e/2PACX-1vR__7O6DlnXXUGEaxhkK_3oesVtv2Zx80H0IAnnmE2s9OVIhTcCT-D-HdJnyqEubRVIg5wPHXdzKU84/pubhtml?gid=2031264111&single=true"> WBS 자세히 보기</a><br> <br>
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/WBS/wbs.png?raw=true" width = "1000"/>

<br><br>

# 💭 DDD 설계

<details><summary> DDD 1차 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/DDD/DDD_1st.jpg"/>
</details>

<details><summary> DDD 2차 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/DDD/DDD_2nd.jpg"/>
</details>

<details><summary> DDD 3차 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/DDD/DDD_3rd.jpg"/>
</details>

<details><summary> DDD 4차 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/DDD/DDD_4th.jpg"/>
</details>

<details><summary> Context Mapping </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/DDD/ContextMapping.jpg"/>
</details>

<br><br>

# 🗃️ DB 모델링
## 논리 모델링
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/Modeling/%EB%85%BC%EB%A6%AC%20%EC%98%A8%EB%8B%B4.png"/>

## 물리 모델링
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/Modeling/%EB%AC%BC%EB%A6%AC%20%EC%98%A8%EB%8B%B4.png"/>
<br><br>

# 🖼️ 화면 설계
## 와이어 프레임
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/WireFrame.png"/>

## UI 설계
### 0. Main
<details><summary>메인 화면</summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/main/main.png?raw=true" width="100%" />
</details>

### 1. Member
<details><summary> 로그인 / 회원가입 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/member/%ED%9A%8C%EC%9B%90,%EB%A1%9C%EA%B7%B8%EC%9D%B8.png?raw=true"/>
</details>

<details><summary> 관리자 프로필 / 회원 관리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/member/%EA%B4%80%EB%A6%AC%EC%9E%90%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true"/>
</details>

<details><summary> 회원 프로필 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/member/%ED%9A%8C%EC%9B%90%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true"/>
</details>

### 2. Counselee
<details><summary> 내담자 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/insert_counselee.png?raw=true" width="100%" />
</details>

<details><summary> 내담자별 상담 일지 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/counselees.png?raw=true" width="100%" />
</details>

### 3. Counsel
<details><summary> 상담 일지 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/create_counsel.png?raw=true" width="100%" />
</details>

<details><summary> 상담 일지 작성 취소 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/cancel_counsel.png?raw=true" width="100%" />
</details>

### 4. Analysis
<details><summary> 상담 일지 상세 확인 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/counsel_1.png?raw=true" width="100%" /> <br />
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/counsel/counsel_2.png?raw=true" width="100%" />
</details>

### 5. Diary
<details><summary> 내 일기 목록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/DiaryPage.png"/>
</details>

<details><summary> 내 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/MyDiary.png"/>
</details>

<details><summary> 받은 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/ReceivedReply.png"/>
</details>

<details><summary> 일기 작성창 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/WriteDiaryModal.png"/>
</details>

<details><summary> 내가 받은 오늘의 일기 목록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/ReceivedDiaryPage.png"/>
</details>

<details><summary> 오늘의 일기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/ReceivedDiary.png"/>
</details>

### 6. Reply
<details><summary> 답장 작성창 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/WriteReplyModal.png"/>
</details>

<details><summary> 내가 보낸 답장 목록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/MyReplyListPage.png"/>
</details>

<details><summary> 내가 보낸 답장 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/diary/MyReply.png"/>
</details>

### 7. Report
<details><summary> 일기 신고 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/report/report_diary.png?raw=true" width="100%" />
</details>

<details><summary> 신고된 일기 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/report/report_diary_process.png?raw=true" width="100%" />
</details>

<details><summary> 답장 신고 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/report/report_reply.png?raw=true" width="100%" />
</details>

<details><summary> 신고된 답장 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/ScreenDesign/report/report_reply_process.png?raw=true" width="100%" />
</details>


<br><br>

# 📑 API 명세서

### 1. Member
<details><summary> 전체 회원 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/select_all_member.png" width="600" />
</details>

<details><summary> id로 회원 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/select_member_by_id.png" width="600" />
</details>

<details><summary> id 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/find_id.png" width="600" />
</details>

<details><summary> 비밀번호 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/find_pwd.png" width="600" />
</details>

<details><summary> 로그인 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/login.png" width="600" />
</details>

<details><summary> 비밀번호 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/change_password.png" width="600" />
</details>

<details><summary> 회원 탈퇴 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/member/delete_member.png" width="600" />
</details>

### 2. Counselee
<details><summary> id로 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_by_id.png" width="600" />
</details>

<details><summary> 상담자id로 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_by_counselor_id.png" width="600" />
</details>

<details><summary> 내담자 생성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/create_counselee.png" width="600" />
</details>

<details><summary> 내담자 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/delete_counselee.png" width="600" />
</details>

<details><summary> 내담자 이름 검색 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/search_counselee_name.png" width="600" />
</details>

<details><summary> 상담자id로 내담자 수 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_counselee_count_by_counselor_id.png" width="600" />
</details>

<details><summary> 상담자id로 활성화 내담자 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counselee/select_activated_counselee_by_counselor_id.png" width="600" />
</details>

### 3. Counsel
<details><summary> 상담사id로 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_counselor_id.png" width="600" />
</details>

<details><summary> 내담자id로 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_counselee_id.png" width="600" />
</details>

<details><summary> 상담 기록 상세 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_detail.png" width="600" />
</details>

<details><summary> 기간별 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_by_timestamp.png" width="600" />
</details>

<details><summary> 예정된 상담 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/select_counsel_future.png" width="600" />
</details>

<details><summary> 상담 생성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/create_counsel.png" width="600" />
</details>

<details><summary> 상담 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/update_counsel.png" width="600" />
</details>

<details><summary> 다음 상담 일시 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/patch_counsel_next_date.png" width="600" />
</details>

<details><summary> 상담 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/counsel/delete_counsel.png" width="600" />
</details>

### 4. Analysis
<details><summary> ChatGPT 분석 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/ChatGPT.png" width="600" />
</details>

<details><summary> 상담id로 분석 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/select_analysis_by_counsel_id.png" width="600" />
</details>

### 4-1. Emotion
<details><summary> 감정 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/create_emotion.png" width="600" />
</details>

<details><summary> 감정 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/update_emotion.png" width="600" />
</details>

<details><summary> 감정 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/delete_emotion.png" width="600" />
</details>

### 4-2. Emotion Category
<details><summary> 감정 카테고리 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/create_emotion_category.png" width="600" />
</details>

<details><summary> 감정 카테고리 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/update_emotion.png" width="600" />
</details>

<details><summary> 감정 카테고리 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/analysis/delete_emotion_category.png" width="600" />
</details>

### 5. Diary
<details><summary> 전체 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_all_diary.png" width="600" />
</details>

<details><summary> 일기id로 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_diary_by_diary_id.png" width="600" />
</details>

<details><summary> 작성자id로 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/select_diary_by_writer_id.png" width="600" />
</details>

<details><summary> 일기 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/create_diary.png" width="600" />
</details>

<details><summary> 일기 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diary/delete_diary.png" width="600" />
</details>

### 5-1. Diary Record
<details><summary> 전체 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_all_diaryRecord.png" width="600" />
</details>

<details><summary> id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_id.png" width="600" />
</details>

<details><summary> 일기id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_diary_id.png" width="600" />
</details>

<details><summary> 수신자로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_receiver_id.png" width="600" />
</details>

<details><summary> 일기id, 수신자id로 일기 발송 기록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/select_diaryRecord_by_diaryId_receiverId.png" width="600" />
</details>

<details><summary> 일기 발송 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/diaryRecord/send_diary.png" width="600" />
</details>

### 6. Reply
<details><summary> 답장 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_all_reply.png" width="600" />
</details>

<details><summary> id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_id.png" width="600" />
</details>

<details><summary> 일기id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_diary_id.png" width="600" />
</details>

<details><summary> 작성자id로 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/select_reply_by_writer_id.png" width="600" />
</details>

<details><summary> 답장 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/write_reply.png" width="600" />
</details>

<details><summary> 답장 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/reply/delete_reply.png" width="600" />
</details>

### 7. Report
<details><summary> 신고 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/all_report.png" width="600" />
</details>

<details><summary> 신고 상세 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_detail.png" width="600" />
</details>

<details><summary> 신고 컨텐츠 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/select_category_content.png" width="600" />
</details>

<details><summary> 신고 카테고리 전체 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/select_all_report_category.png" width="600" />
</details>

<details><summary> 일기 신고 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_diary.png" width="600" />
</details>

<details><summary> 답장 신고 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_reply.png" width="600" />
</details>

<details><summary> 신고 처리 상태 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/report_update.png" width="600" />
</details>

<details><summary> 신고 승인된 일기/답장 블라인드 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/blind_report.png" width="600" />
</details>

<details><summary> 신고 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/delete_report.png" width="600" />
</details>

<details><summary> 신고 카테고리 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/create_report_category.png" width="600" />
</details>

<details><summary> 신고 카테고리 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/update_report_category.png" width="600" />
</details>

<details><summary> 신고 카테고리 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/PostmanPictureAPI/report/delete_report_category.png" width="600" />
</details>


<br><br>

# 🚩 단위 테스트
<img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Summary.png" width="600" />

<details>
  
  ### 1. Member
  <details><summary> Summary </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Member/MemberTestSummary.png" width="600" />
  </details>
  
  <details><summary> Member Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Member/MemberCommandTest.png" width="600" />
  </details>
  
  <details><summary> Member Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Member/MemberQueryTest.png" width="600" />
  </details>
  
  ### 2. Counselee
  <details><summary>  </summary>
    <img src="">
  </details>
  
  ### 3. Counsel
  <details>
    <img src="">
  </details>
  
  ### 4. Analysis
  <details><summary> Summary </summary>
    <img src="">
  </details>
  
  <details><summary> Analysis Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Analysis/AnalysisCommandTest.png" width="600" />
  </details>
  
  <details><summary> Analysis Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Analysis/AnalysisQueryTest.png" width="600" />
  </details>
  
  <details><summary> Emotion Category Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Analysis/EmotionCategoryCommandTest.png" width="600" />
  </details>
  
  <details><summary> Emotion Category Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Analysis/EmotionCommandTest.png" width="600" />
  </details>
  
  ### 5. Diary
  <details><summary> Summary </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Diary/DiaryTestSummary.png" width="600" />
  </details>
  
  <details><summary> Diary Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Diary/DiaryCommandTest.png" width="600" />
  </details>
  
  <details><summary> Diary Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Diary/DiaryQueryTest.png" width="600" />
  </details>
  
  ### 6. Diary Record
  <details><summary> Summary </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/DiaryRecord/DiaryRecordTestSummary.png" width="600" />
  </details>
  
  <details><summary> Diary Record Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/DiaryRecord/DiaryRecordCommandTest.png" width="600" />
  </details>
  
  <details><summary> Diary Record Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/DiaryRecord/DiaryRecordQueryTest.png" width="600" />
  </details>
  
  ### 7. Reply
  <details><summary> Summary </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Reply/ReplyTestSummary.png" width="600" />
  </details>
  
  <details><summary> Reply Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Reply/ReplyCommandTest.png" width="600" />
  </details>
  
  <details><summary> Reply Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Reply/ReplyQueryTest.png" width="600" />
  </details>
  
  ### 8. Report
  <details><summary> Summary </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Report/ReportTestSummary.png" width="600" />
  </details>
  
  <details><summary> Report Category Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Report/ReportCategoryCommandTest.png" width="600" />
  </details>
  
  <details><summary> Report Command Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Report/ReportCommandTest.png" width="600" />
  </details>
  
  <details><summary> Report Query Test </summary>
    <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/TestCase/Report/ReportQueryTest.png" width="600" />
  </details>
  
</details>

<br><br>

# ✍🏻 API TEST

### 1. Member
<details><summary> 회원가입 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.gif?raw=true" width="800" />
</details>
<details><summary> 이메일 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%EC%9D%B4%EB%A9%94%EC%9D%BC%EC%B0%BE%EA%B8%B0.gif?raw=true" width="800"/>
</details>
<details><summary> 비밀번호 찾기 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%EC%B0%BE%EA%B8%B0.gif?raw=true" width="800" />
</details>
<details><summary> 로그인 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%EB%A1%9C%EA%B7%B8%EC%9D%B8.gif?raw=true" width="800" />
</details>
<details><summary> 회원 비밀번호 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%ED%9A%8C%EC%9B%90%20%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EB%B3%80%EA%B2%BD.gif?raw=true" width="800" />
</details>
<details><summary> 회원 탈퇴 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%ED%9A%8C%EC%9B%90%20%ED%83%88%ED%87%B4.gif?raw=true" width="800" />
</details>
<details><summary> 관리자 프로필 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%EA%B4%80%EB%A6%AC%EC%9E%90%20%ED%94%84%EB%A1%9C%ED%95%84.gif?raw=true" width="800" />
</details>
<details><summary> 회원 상세 정보 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%ED%9A%8C%EC%9B%90%20%EC%83%81%EC%84%B8%20%EC%A0%95%EB%B3%B4.gif?raw=true" width="800" />
</details>
<details><summary> 회원 권한 변경 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/member/%ED%9A%8C%EC%9B%90%20%EA%B6%8C%ED%95%9C%20%EB%B3%80%EA%B2%BD.gif?raw=true" width="800" />
</details>


### 2. Counselee
<details><summary> 내담자 목록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/move_counsel.gif?raw=true" width="800" />
</details>
<details><summary> 내담자 등록 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/insert_counselee.gif?raw=true" width="800"/>
</details>
<details><summary> 내담자 등록 시 필수 정보 관련 모달 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/insert_counsel_modal.gif?raw=true" width="800" />
</details>
<details><summary> 내담자 등록 취소 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/counselee_cancle.gif?raw=true" width="800" />
</details>


### 3. Counsel
<details><summary> 내담자별 상담 일지 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/check_counselee.gif?raw=true" width="800" />
</details>
<details><summary> 상담 일지 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/counsel.gif?raw=true" width="800" />
</details>
<details><summary> 상담 일지 작성 취소 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/counsel_cancle.gif?raw=true" width="800" />
</details>

### 4. Analysis
<details><summary> 상담 일지 상세 확인 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/counsel/analysis_detail.gif?raw=true" width="800" />
</details>

### 5. Diary
<details><summary> 일기 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/DiaryPage.gif" width="800" />
</details>

<details><summary> 일기 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/WriteDiary.gif" width="800" />
</details>

<details><summary> 일기 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/DeleteDiary.gif" width="800" />
</details>

### 6. Reply
<details><summary> 답장 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/ReadReply.gif" width="800" />
</details>

<details><summary> 답장 작성 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/WriteReply.gif" width="800" />
</details>

<details><summary> 답장 삭제 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/GIF/diary/DeleteMyReply.gif" width="800" />
</details>

### 7. Report
<details><summary> 받은 일기 신고 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_diary.gif?raw=true"/>
</details>

<details><summary> 신고 목록 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_list.gif?raw=true"/>
</details>

<details><summary> 신고 상세 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_detail.gif?raw=true"/>
</details>

<details><summary> 신고 대상 콘텐츠 조회 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_target_content.gif?raw=true"/>
</details>

<details><summary> 신고 처리상태 수정 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_status_update.gif?raw=true"/>
</details>

<details><summary> 신고 승인된 일기 블라인드 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_diary_blind_approve.gif?raw=true"/>
</details>

<details><summary> 받은 답장 신고 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_reply.gif?raw=true"/>
</details>

<details><summary> 신고 승인된 답장 블라인드 처리 </summary>
  <img src="https://github.com/Pive-Guyz/ondam-backend/blob/develop/document/APITest/report/report_reply_blind_approve.gif?raw=true"/>
</details>


<br><br>

# 🛜 배포

<details><summary>🌐 Ingress 설정 (ondam-ingress)</summary>

```yaml
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: ondam-ingress
  namespace: ondam
  annotations:
    nginx.ingress.kubernetes.io/ssl-redirect: "false"
spec:
  ingressClassName: nginx
  rules:
    - http:
        paths:
          - path: /api
            pathType: Prefix
            backend:
              service:
                name: ondam-back-ser
                port:
                  number: 8080
          - path: /
            pathType: Prefix
            backend:
              service:
                name: ondam-front-ser
                port:
                  number: 80
```

</details>

<details><summary>🚀 Backend Deployment (ondam-back-dep)</summary>

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: ondam-back-dep
  namespace: ondam
spec:
  replicas: 1
  selector:
    matchLabels:
      app: ondam-backend
  template:
    metadata:
      labels:
        app: ondam-backend
    spec:
      containers:
        - name: ondam-backend
          image: morris235/ondam-backend:latest
          imagePullPolicy: Always
          ports:
            - containerPort: 8080
```

</details>

<details><summary>🔧 Backend Service (ondam-back-ser)</summary>

```yaml
apiVersion: v1
kind: Service
metadata:
  name: ondam-back-ser
  namespace: ondam
spec:
  type: NodePort
  selector:
    app: ondam-backend
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
      nodePort: 30083
```

</details>

<details><summary>🚀 Frontend Deployment (ondam-front-dep)</summary>

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: ondam-front-dep
  namespace: ondam
spec:
  replicas: 1
  selector:
    matchLabels:
      app: ondam-frontend
  template:
    metadata:
      labels:
        app: ondam-frontend
    spec:
      containers:
        - name: ondam-frontend
          image: morris235/ondam-frontend:latest
          imagePullPolicy: Always
          ports:
            - containerPort: 80
```

</details>

<details><summary>🔧 Frontend Service (ondam-front-ser)</summary>

```yaml
apiVersion: v1
kind: Service
metadata:
  name: ondam-front-ser
  namespace: ondam
spec:
  selector:
    app: ondam-frontend
  type: NodePort
  ports:
    - port: 80
      targetPort: 80
      nodePort: 30080
```

</details>


---

<details><summary>🧩 CI/CD 구성 개요</summary>

- **멀티 레포 구성**: `frontend/`, `backend/`를 Git Submodule로 관리  
- **CI (Jenkins)**: 변경된 서비스만 빌드 및 Docker Hub에 이미지 푸시  
- **CD (Argo CD)**: Git 상태와 Kubernetes 클러스터 자동 동기화  
- **Docker**: Apple Silicon 대응 multi-arch 이미지 빌드  
- **Kubernetes**: 무중단 배포를 위한 `rollout restart` 전략 적용  

</details>

<details><summary>🛎️ 초기 수동 배포 → Jenkins 자동화 전환</summary>

#### ✴️ 수동 배포 당시
- `build-*.sh`, `deploy-*.sh` 와 같은 스크립트를 직접 만들어 실행  
- 반복 작업과 실수 발생 확률 줄임  
- 명령어 문서화 효과로 추후 리마인드 가능  

#### ✅ Jenkins 도입 후
- Webhook 기반 자동 트리거  
- 변경된 서비스만 선택적으로 빌드/배포  
- **무중단 배포 (`rollout restart`) 지원**  
- `.yml` 수정까지 포함하여 **Argo CD에 반영 가능**  

</details>

<details>
  
<summary>⚙️ Jenkins + Argo CD 파이프라인 흐름</summary>

#### ✅ Jenkins (CI)
- GitHub Webhook 기반 트리거 (main 브렌치)  
- 하나의 webhook 신호로 서브모듈별 변경 감지 → 프론트와 백엔드 각각 배포  
- Docker 이미지 빌드 및 Push  
- `k8s/*.yml` 이미지 태그 업데이트 후 Git push
![ondam-jenkins](https://github.com/user-attachments/assets/cc615626-fab8-4d35-a916-b8ade3d4d042)

#### ✅ Argo CD (CD)
- Git 상태 감지 → 클러스터 상태 자동 동기화  
- UI로 배포 상태 모니터링 및 롤백 지원

<img width="1452" alt="argocd-sync" src="https://github.com/user-attachments/assets/58221e60-d3b2-4b85-9aa5-a351c7f3711e" />

<img width="1439" alt="argocd-status2-1" src="https://github.com/user-attachments/assets/0ab763b5-ad79-46af-9d47-1e90df9d9e6d" />

<img width="1442" alt="argocd-status2-2" src="https://github.com/user-attachments/assets/63c6faca-aa1e-429c-b85a-db5828dfc96c" />

</details>

<details><summary>🧱 멀티레포 구성의 장단점</summary>

#### 장점
- **독립적인 빌드 및 배포 가능**  
  - 프론트 변경 시 → `frontend`만 빌드/배포  
  - 백엔드 변경 시 → `backend`만 빌드/배포  
  - Jenkins는 메인 레포 기준으로 하나의 Webhook을 받아 git diff로 변경 감지 후 해당 서브모듈만 빌드 & 배포  

- **협업 효율 증가**  
  - 팀원 간 코드 충돌 최소화  
  - 개발과 배포작업을 병렬적으로 처리 가능  

#### 단점
- **submodule 동기화 이슈**  
  - git submodule update, status, 커밋 누락 등의 실수 발생 가능  
  - 프론트/백을 수정한 뒤 메인 레포에서 커밋 포인터를 갱신해야 하는 작업 오버헤드 발생  

- **구조적 문제**  
  - Github Actions등 다른 CI를 쓰기 어렵고, Jenkins 중심 구조가 고착됨  
  - submodule이 늘어 날수록 유지보수가 어려워짐 (2~3개가 한계)  
  - 하나의 파이프라인으로 N개 이상의 서비스를 배포하기 때문에 복잡성이 증가하고 이력관리가 어려움  

</details>

<details><summary>🚀 Argo CD를 통한 무중단 배포</summary>

- `main` 브랜치의 `k8s/*.yml`이 변경되면 Argo CD가 자동 감지  
- `kubectl rollout restart` 명령과 함께 사용하면,  
  Pod 교체 과정에서 기존 트래픽은 유지되므로 **무중단 배포가 가능**  

</details>

<details><summary>✅ 실행 결과 요약</summary>

1. GitHub → `main` 브랜치에 push 발생  
2. Jenkins Webhook 트리거 → 파이프라인 실행  
3. 변경된 서비스만 빌드 및 Docker 이미지 생성  
4. DockerHub 푸시 + `k8s/*.yml` 수정 및 Git push  
5. Argo CD가 자동 감지 → 클러스터 동기화  
6. **frontend/back 각각의 변경에 대해 독립적, 무중단 배포 실행**  

</details>

<details><summary>🌿 브랜치 전략 및 배포 흐름</summary>

#### 🗂 배포 브랜치 구조

- `develop`: 기능 개발 및 통합 테스트 진행  
- `deploy/dev-snapshot`: 배포 직전 단계의 검증 브랜치  

#### 🔗 멀티레포 연동 방식

- `frontend/`, `backend/`는 각각 별도의 독립 레포로 운영됨  
- 메인 레포인 `be14-4th-piveguyz-ondam`에는 두 레포가 Git Submodule로 연결되어 있음  
- 브랜치 전략은 **서브모듈에서도 동일하게 적용**되며,  
  - `develop` → `deploy/dev-snapshot` → 메인 레포의 main 브렌치에 반영 → jenkins, Argo CD 배포 흐름으로 이어짐  

#### ✅ 흐름 요약

1. 기능은 각 서비스 레포의 `develop` 브랜치에서 개발  
2. 기능 완료 시 `deploy/dev-snapshot`로 머지하여 배포 대상 확정  
3. 메인 레포지토리의 Submodule을 업데이트하여 `main` 브랜치로 커밋  
4. Jenkins → Argo CD로 이어지는 자동화 배포 트리거  

</details>

<br><br>

# 🔜 향후 확장 계획

### 1. 실시간 상담 분석

- 상담 중 AI에게 상담 내용을 실시간으로 전달하고 즉시 감정 분석 결과를 받아볼 수 있도록 기능을 확장할 계획입니다.  
- 이를 통해 상담사는 내담자의 감정 상태를 상담 중 바로 파악하고 효과적인 대응이 가능해집니다.

### 2. STT (Speech to Text) 연동

- 상담 내용을 음성으로 입력하면 자동으로 텍스트로 변환하는 기능을 도입할 예정입니다.  
- 상담사가 메모 없이 상담에 집중할 수 있으며, 청각장애 상담사도 실시간 상담 내용을 쉽게 확인할 수 있습니다.

### 3. 사진 기반 상담 기록 정리 (OCR)

- 상담 중 작성한 메모나 노트를 사진으로 업로드하면  
  AI가 이미지 내 텍스트를 인식하여 상담 기록으로 자동 정리하는 기능을 추가할 예정입니다.  
- 상담사의 기록 부담을 더욱 줄여주고 기록의 일관성을 높일 수 있습니다.

### 4. AI 분석 결과 고도화 및 리포트 강화

- 축적된 상담 데이터를 바탕으로 내담자별 감정 변화 패턴 분석과 상담 리포트 기능을 강화할 예정입니다.  
- 이를 통해 상담사는 더 정교하고 맞춤화된 상담 전략을 수립할 수 있습니다.

### 5. 상담사 커뮤니티 기능

- 랜덤 일기를 넘어, 상담사 간 의견 교환과 지식을 나눌 수 있는 커뮤니티 기능을 도입할 계획입니다.  
- 상호 지지를 통해 정서적 안정과 전문성 향상을 도울 수 있습니다.

<br><br>

# 🦄 프로젝트 소감

### 곽우석
####  이번 프로젝트에서 맡은 역할
- 로그인, 로그아웃, 회원가입, 아이디/비밀번호 찾기, 회원 탈퇴 등 **회원 기능 전반 구현**  
- **관리자 페이지** 설계 및 구현  
- **피그마**를 활용한 프론트엔드 기획 및 설계 
- **Git 브랜치 전략** 수립, 커밋/이슈/PR 컨벤션 정립  
- **GitHub 웹훅** 연동 등 협업을 위한 환경 구성  

####  잘한 점
- 전반적인 회원 기능 흐름을 안정적으로 설계하고 구현하여 서비스의 기반을 탄탄하게 다짐  
- 로그인부터 탈퇴까지 모든 사용자 플로우를 연결하며 프론트와 백을 유기적으로 연동함  
- Git 브랜치 전략, 커밋/PR 컨벤션, 웹훅 등을 적용해 **협업 환경 개선에 기여**  

####  아쉬운 점
- 일부 기능 구현 시 예상보다 시간이 소요되어 작업 속도 면에서 아쉬움이 남음  
- 기능 단위 테스트나 예외 처리에 대한 체계적인 준비가 부족했던 점  
- 프로젝트 후반부에 작업 분담 외 공통 작업 기여가 부족했던 점

####  배운 점
- 로그인/회원가입 등 인증 흐름을 직접 구현하며 **보안 처리 및 사용자 경험 설계**에 대한 이해도가 높아짐  
- Git 협업 시 브랜치 전략과 커밋 컨벤션의 중요성을 실무처럼 체감함  
- 프론트와 백을 모두 다루며 **단순 구현을 넘어 기능 통합** 관점에서의 사고가 확장됨  

####  다음 프로젝트에 적용하고 싶은 점
- 작업 시작 전 기능 구조를 먼저 명확히 설계하여 구현 시 **리팩토링 최소화**  
- 이슈 및 PR 작성 시 다른 팀원들도 쉽게 파악할 수 있도록 **명확한 설명**  
- 일정 관리 도구를 활용하여 **전체 작업 흐름의 가시성 확보**  



---
### 🐿️ 김석희
#### 이번 프로젝트에서 맡은 역할
 - 프론트엔드 구현
   - 피그마를 활용해 UI/UX 기획 및 설계
   - 상담 일지 페이지, 메인 페이지, 예외 페이지 등 구현
 - 백엔드 구현
   - GPT API를 연동해 상담 분석 로직 구현
   - GPT 응답 데이터 파싱 및 데이터 저장
   - 감정 관련 정보 저장 및 수정, 삭제 구현

#### 잘한 점
 - GPT API를 프로젝트에 성공적으로 연동하고 해당 결과를 프론트 상에서 가독성 있게 표현했음
 - ExceptionHandler을 사용해 에러 처리를 중앙화해 반복되는 에러 처리 코드를 간결화함
 - 프로젝트 회의, 기획서 등을 문서화로 만들어 팀원들과 공유함
 - 담당 작업을 끝낸 후 공통으로 수행해야 할 작업을 먼저 나서서 완성함

#### 아쉬운 점
 - 기능을 개발할 때 사전에 설계하지 않고 개발을 진행해 기능을 완성했음에도 코드를 리팩토링하는 일이 잦았음
 - 팀원들끼리 작업 중인 사항을 실시간으로 공유하지 못한 것이 아쉬웠음
 - ISSUE를 꼼꼼하게 작성하지 못한 점이 아쉬웠음

#### 배운 점
 - 급하게 개발을 진행하는 것보다 기획과 설계를 꼼꼼하게 수행하는 것이 중요함을 배웠음
 - API를 활용하면서 비동기 처리와 캐싱의 중요성에 대해 배울 수 있었음
 - yml 파일로 관리할 데이터와 해당 데이터를 사용하는 방법에 대해 배울 수 있었음

#### 다음 프로젝트에 적용하고 싶은 점
 - 'Jira'나 'Trello'를 사용한 일정 관리
 - 전체 작업 목록을 공유하고 중요도를 설정한 후에 프로젝트 진행
 - 협업을 위한 PR 전략 수립
 - 유지 보수성과 가독성을 고려한 코드 구현
---

### 🤖 서민종
#### 이번 프로젝트에서 맡은 역할
 - 프론트엔드 구현
   - 피그마를 이용하여 일기, 답장 도메인 화면 UI/UX 설계
   - Vue와 vuetify 라이브러리를 활용하여 일기 도메인 화면 및 기능 구현
 - 백엔드 구현
   - 일기 도메인 CURD 기능 구현
   - 답장 도메인 CURD 기능 구현
   - 스케줄러를 활용한 자동 일기 발송 기능 구현
   - 일기 및 답장 작성에 따른 회원 포인트 수정 로직 설계

#### 잘한 점
 - 다른 팀원들의 PR요청에 대한 API 케이스를 미리 문서화하여 API 명세서 작성을 할 때 작업 시간을 단축시킴
 - 다른 팀원의 오류 문제에 대해 콘솔 로그창을 확인하고 AI를 활용하여 문제 해결에 도움을 줌
 - 백엔드 기능 전체 로직에 대하여 다른 팀원에게 설명해주고 이해시켜 백엔드 기능 구현을 도와줌
 - 프로젝트 시연 자리에서 서비스의 설계 배경과 차별점, 기능들에 대하여 설명을 함

#### 아쉬운 점
 - 프로젝트 과정에서 생긴 문제에 대한 트러블 슈팅을 진행하지 못했음
 - 기능에 대한 형식의 통일이 늦게 이루어져 기능 구현이 끝난 코드에 대한 수정이 자주 이루어졌음
 - 각 팀원이 도메인 단위로 작업이 배분되어 작업속도와 난이도에 맞는 적절한 할당량이 배분되지 않았다고 생각됨

#### 배운 점
 - git을 이용한 협업 과정에서 이슈, PR, 브랜치에 대한 구체적인 컨벤션 형식과 적용하는 방법에 대해 상세히 배울 수 있었음
 - yml파일이나 json파일과 같이 gitignore에 포함되야하는 데이터와 아닌 데이터의 차이와 그 이유에 대해 배울 수 있었음
 - 백엔드와 프론트엔드 각각의 디테일한 부분과 두 서비스를 잇는 과정에서의 어려움에 대하여 더 실감할 수 있었음
 - 잦은 충돌을 해결하는 과정에서 git의 브랜치 관리 방법과 협업하는 과정에 대해 더 깊게 이해할 수 있었음

#### 다음 프로젝트에 적용하고 싶은 점
 - 더 디테일한 부분에 대한 기능의 완벽 구현
 - 실시간 채팅 서비스
 - 토큰을 활용한 로그인(Auth2)
---
### 이상모

### 최혜민
