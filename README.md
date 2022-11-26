# 셔틀버스 실시간 지도
부산외국어대학교 컴퓨터공학과 캡스톤디자인 수업에서 제작된 교내 셔틀버스의 위치를 실시간으로 확인할 수 있는 지도 PWA입니다
https://github.com/kmseonhwa/live-shuttle-map-client README 참고

(백엔드)
## 기술스택
* 개발언어 : Java 17
* 개발환경 : SpringBoot 2.6.4
* 빌드 : maven
* 데이터베이스 : MySQL
* 형상관리 툴 : GitHub

## 구현기능
* 계정 관련
  * 사용자 CRUD, ID 찾기, 회원가입, OAuth2 로그인(카카오)
* 관리자 페이지
  * 셔틀버스 위치 초기화, 관리자 계정 CRUD
* 셔틀버스 위치 관련
  * 전체 위치 조회, 각 셔틀버스 위치 조회, 버스CRUD
* 사용자 위치 마커
  * 사용자 위치 마커 CRUD
  
