
- [테스트용 http 파일](api.http)
- [테스트 Swagger](http://ec2-13-124-241-199.ap-northeast-2.compute.amazonaws.com:8080/swagger-ui/index.html)

# API 명세서

## 직원 관리 API

### 직원 개인정보 조회

특정 직원의 현재 인사 정보를 조회하는 API입니다.

`GET /employees/{employeeId}`

**Path Variables**

- `employeeId`: 직원 고유 번호

### 직원 직무 이력 조회

특정 직원의 과거 직무 변경 이력을 조회하는 API입니다.

`GET /employees/{employeeId}/history`

**Path Variables**
- `employeeId`: 직원 고유 번호

### 직원 정보 수정
직원의 개인정보 및 인사정보를 수정하는 API입니다.

`PUT /employees/{employeeId}`

**Path Variables**
- `employeeId`: 직원 고유 번호

**Request Body**
```json
{
  "firstName": "이름",
  "lastName": "성",
  "email": "이메일",
  "phoneNumber": "전화번호",
  "hireDate": "입사일(YYYY-MM-DD)",
  "salary": "급여(숫자)",
  "departmentId": "부서ID(숫자)",
  "jobId": "직무ID"
}
```

## 부서 관리 API

### 부서 목록 조회
회사의 전체 부서 목록을 조회하는 API입니다.

`GET /departments`

### 부서 급여 일괄 인상
특정 부서에 속한 모든 직원의 급여를 지정된 비율로 인상하는 API입니다.

`POST /departments/salary`

**Query Parameters**
- `departmentId`: 급여를 인상할 부서의 ID
- `percentage`: 급여 인상률(%)

## 치과 검색 API

### 지역별 치과 목록 검색
지정된 지역의 치과 목록을 페이징 처리하여 조회하는 API입니다.

`GET /dentist/search`

**Query Parameters**
- `pageNo`: 조회할 페이지 번호
- `pageNum`: 한 페이지당 표시할 치과 수
- `region`: 검색할 지역 코드
    - `DJ`: 대전광역시
    - `DG`: 대구광역시
    - `KG`: 경기도
