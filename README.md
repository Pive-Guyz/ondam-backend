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
| 이름 | 내용 |
|:---:|-|
|곽우석| 이번 프로젝트에서 힘내주신 팀원들에게 우선 고맙고 고생했다는 말로 시작하고 싶습니다. 짧은 기간 동안 프로젝트를 진행하면서도 굉장히 많은 일들이 있었던 것 같습니다. 처음부터 평범하지 않았던 우리 5조, 27분의 1 확률을 뚫고 당첨되어 조장이 된 우석.. 덕분에 이전에 생각지도 못한 조합으로 예기치 않게 함께 하게 된 5조였지만 굉장히 잘 지냈다고 말하고 싶습니다. <br><br>이번 프로젝트에서 이전에 경험했던 프로젝트에서 도커를 이용한 배포가 추가됐는데 이전까지 해왔던 백엔드와 프런트 작업이지만 매번 프로젝트를 할 때마다 배우는 점이 생기는 것 같습니다. 덕분에 이번 프로젝트도 보람참과 흥미를 느끼며 즐거운 시간을 보냈습니다. <br><br>약 3주간을 돌이켜보면 프로젝트 초반 주제 선정에서 꽤 어려움을 겪었던 것 같습니다. 모두가 동의했던 게임 주제가 엎어지면서 다들 굉장히 당황해했습니다. 하지만 모두들 많은 의견을 내주었고 그 과정 속에서 다들 기분이 상할 수도 있었지만 서로 무사히 넘길 수 있었습니다. 상대적으로 길었던 일주일의 주제 선정을 끝마치고 저희는 본격적인 기능 구현에 들어갔습니다. <br><br>이번 프로젝트에서 회원 파트를 맡았을 때 처음에 꽤나 쉽지 않았던 기억이 납니다. 하지만 혼자 공부하며 "이 어려움을 극복하면 나에게 많은 것이 남을 것이다"라고 되새겼습니다. 그럼에도 어려움이 많았지만 민종 님을 비롯한 다른 팀원들이 많은 도움을 주셔서 수월하게 끝낼 수 있었습니다. 매번 느끼지만 이게 바로 협업의 힘이구나 다시 한번 실감했습니다. 작업 속도가 느려 미안한 마음이 많이 남았는데 다음에는 더욱 열심히 하여 다른 팀원들에게 도움을 더 많이 줄 수 있는 사람이 되고 싶습니다. <br><br>쉽지 않은 배포를 맡은 상모님, 항상 기록을 열심히 해주셔서 팀원들에게 큰 도움이 된 석희님, 저의 없어서는 안 될 GPT 민종님, 우리 팀의 디자인 선생님 혜민님 그리고 이외에도 고마운 부분이 너무나도 많았습니다.다들 빡빡한 기간 속에서도 맡은 일에 책임을 다하는 모습이 인상적이었습니다. 다음 프로젝트에서는 또 어떤 새로움 배움이 생길지 기대됩니다.|
|서민종| 우선 같이 열심히 노력해준 다른 팀원분들께 감사의 말씀을 드리고 싶네요. 2주 반 정도의 짧은 기간 동안 프로젝트를 진행하면서 많이 빠듯하고 정신 없게 진행해서 힘들기도 했지만 백엔드와 프론트엔드 코딩 및 배포까지 모든 영역을 전부 구현하며 아주 의미가 있었던 프로젝트라고 생각합니다. 처음 주제를 선정할 때 마땅한 주제가 떠오르지 않아서 3번에 걸쳐서 수정하면서 고생을 좀 했던 거 같아요. 그러다보니 비교적 늦게 설계를 들어가서 서둘러서 DDD설계랑 ERD를 끝내고 도메인 별로 역할을 나눠서 백엔드와 프론트엔드 구현에 들어갔어요. 그래도 이전에 각각 프로젝트를 진행해본 경험이 있어서 비교적 더 수월하게 진행할 수 있었어요. 그리고 배포까지 적용을 한 뒤에 서비스를 이용하게끔 부스 형태로 공간을 열었는데, 평가를 진행하는 강사님과 매니저님, 그리고 다른 부트캠프 학생분들도 서비스를 실행하고 설명을 잘 들어주시면서 좋다고 많이 칭찬을 남겨주셔서 정말 감사했습니다. 팀원 분들이 각자 맡은 부분에서 열심히 노력해주신 덕분에 이런 좋은 결과가 나왔다고 생각합니다. 우선 우석님은 조장으로서 부담을 느낄 수 있는 자리임에도 불구하고 책임감을 가지고 조원분들이 감정 상하지 않고 잘 융화되서 협업할 수 있도록 잘 이끌어 주셨습니다. 그리고 모든 기능의 시작점이자 기둥인 회원가입 및 로그인 기능을 잘 구현해 주셨어요. 석희님은 AI 연동 기능을 도맡아서 완벽히 구현해 주셨어요. 그리고 프로젝트 전체적인 진행을 파악하고 문서화하면서 회의를 주도해서 진행해주셔서 프로젝트가 큰 문제 없이 무난히 잘 진행될 수 있었던 것 같아요. 상모님은 프로젝트의 도커 및 쿠버네티스 툴을 이용한 배포를 책임지셨어요. 새롭게 배운 내용이라 시간에 쫓기기도 하고 난이도가 높은 부분일텐데 완전히 구현해주셔서 정말 대단하다고 느꼈습니다. 또한, 브랜치와 패키지 형식 및 백엔드 요청 형식의 통일화를 진행하셔서 가독성을 높여주셨어요. 혜민님은 디자인 부분을 맡아서 피그마 작업 쪽으로 많은 도움을 주셨어요. 전체적인 테마와 색을 정하고 헤더와 푸터같은 컴포넌트 설계를 디자인적으로 깔끔하고 예쁘게 디자인하셔서 서비스의 질도 높이고 전체 기능의 틀도 빠르게 잡힐 수 있도록 해주셨어요. 마지막으로 프로젝트에서 의미 있는 결과를 만들어내고 다 함께 노력해주신 모든 분들께 다시 한번 감사합니다.😃 |
|이상모| 이 프로젝트 주제를 선정하기까지 선생님으로부터 총 2번의 퇴짜를 맞았습니다.<br><br>첫번째는 게임이었는데 이건 우리 팀원들이 대체로 흥미 있어하는 주제였지만 정작 우리가 목표로한 백엔드 개발자가 아니라 프론트 개발자 영역에 가까운 주제였기 때문이었습니다. 그리고 가장 중요한건 이 프로그램으로 우리가 무슨 문제를 해결하고 싶은지가 전혀 들어가 있지 않았다는 것입니다.<br><br>게임을 통해 사람들에게 즐거움을 주겠다는 목표는 있었지만, 실상 그 대상은 외부 유저가 아니라 우리 팀원들 자신이었습니다. 아마추어로서는 이 주제로 우리들끼리 즐겁게 개발할 수야 있었겠지만 저희가 지향하고 있는건 프로입니다. 프로는 보수를 받는 만큼 고객을 만족 시킬수 있어야 합니다. 우리의 입장에서 고객이란 프로그램을 이용하는 유저는 물론이고 어쩌면 직장 상사, 기획자, 디자이너, 회사 대표가 될 수도 있을 겁니다. 하지만 이건 그저 우리만 만족 시키는 주제였습니다.<br><br>그래서 함께 고민해서 나온 주제가 고독사 방지 프로그램이었습니다. 게임보다는 어떤 문제를 해결해야 할지 명확해 졌지만 이 또 한 우리 프로그램을 이용할 타겟이 좁혀지지 않아서 기능 기획이 중구난방 이었습니다. 우리에게 주어진 개발 시간과 능력을 고려하여 결국 좁혀진 타겟은 상담사였습니다. 상담사를 케어하고, 상담사의 문서 작성 부담을 줄여주면, 결과적으로는 사회에서 소외되고 고립된 사람들에게도 도움이 될 수 있다고 생각했습니다.<br><br>이번 수업의 산출물은 자동 배포 파이프라인이었지만, 우리 팀에게 진정한 성과는 개발이 무엇을 위한 것인가 라는 본질을 깨닫게 된 경험 그 자체였습니다. 끝으로 함께 고생하고 프로젝트 완성도를 높이기 위해 밤까지 설쳤던 팀원들과 우리를 지금까지 지도해주시고 끊임없이 가르침과 통찰을 주신 선생님께 마음 깊이 감사 인사를 드립니다. |
|최혜민| 벌써 네 번째 프로젝트가 끝났다. 프로젝트를 시작할 때마다 "이번엔 더 열심히 해서 팀에 도움이 되어야지"라고 다짐하지만, 역시 쉽지는 않았다. 부족한 부분도 여전히 많았고, 잘 안 풀릴 때마다 스스로 답답해지기도 했다. 특히 이번 프로젝트는 더 걱정이 많았다. 팀원이 줄어들어서 더 많은 걸 신경 써야 했고, 해야 할 일도 생각보다 많았다. 과연 잘 해낼 수 있을지 불안했지만, 다행히 팀원들이 적극적으로 도와줬다. 어려운 일도 척척 해결해주고, 내가 막히는 부분도 같이 고민해주면서 정말 큰 힘이 됐다. 그 덕분에 많이 배우기도 했고, 덜 부담스럽게 프로젝트를 이어갈 수 있었다. 한편으로는 아직 혼자서 해내기에는 부족한 점이 많다는 걸 느꼈다. 그래도 예전보다 조금 더 할 수 있는 게 늘어난 것 같아서, 그게 나름대로 의미 있는 성장이라고 생각한다. 최종 프로젝트에서는 더 철저하게 준비하고, 맡은 일도 실수 없이 잘 해내면서 지금보다 더 주도적으로 참여하고 싶다. 그리고 이번보다 더 든든하게 팀에 도움이 되는 사람이 되고 싶다. |

### 곽우석


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

### 서민종

### 이상모

### 최혜민
