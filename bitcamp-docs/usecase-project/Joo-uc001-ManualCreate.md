#UC001 - 매뉴얼 등록하기
기업이 시스템을 이용하기 위해 매뉴얼을 등록하는 유스케이스

## 주 액터(Primary Actor)
기업

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)
- 게시판을 등록할 수 있는 이용자는 기업 회원이다
- 게시판에 동일한 제품의 매뉴얼이 등록되어 있지 않다.

## 종료 조건(Postconditions)
- 매뉴얼 정보가 매뉴얼 폼에 등록 되었다

## 시나리오(Flow of Events)

## 기본 흐름(Basic Flow of Events)
- 1. 액터가 새로운 매뉴얼 등록하기 버튼을 클릭할 때 이 유스케이스를 시작한다
- 2. 시스템은 매뉴얼 등록 폼 중 '모델명 입력' 을 출력한다.
- 3. 액터는 모델명을 작성한 뒤 '다음' 버튼을 누른다.
- 4. 시스템은 모델명을 저장한 뒤, 매뉴얼 등록 폼 중 '레이아웃 선택'을 출력한다.
- 5. 액터는 레이아웃을 선택한 뒤 '다음' 버튼을 누른다.
- 6. 시스템은 레이아웃을 저장한 뒤 매뉴얼 등록 폼 중 '첨부파일 선택'을 출력한다.
- 7. 액터는 첨부파일을 선택한 뒤 '다음' 버튼을 누른다.
- 8. 시스템은 첨부파일을 저장한 뒤 매뉴얼 등록 폼 중 '첨부파일에 대한 설명 입력'을 출력한다.
- 9. 액터는 첨부파일에 대한 설명을 작성한 뒤 '다음' 버튼을 누른다.
- 10. 시스템은 첨부파일에 대한 설명을 저장한 뒤 매뉴얼 등록 폼 중 '스펙 정보 입력'을 출력한다.
- 11. 액터는 스펙 정보를 입력한 뒤 '다음' 버튼을 누른다.
- 12. 시스템은 스펙 정보를 저장한 뒤 매뉴얼 등록 폼 중 '주변기기 등록'을 출력한다.
- 13. 액터는 주변기기 정보를 입력한 뒤 '다음' 버튼을 누른다.
- 14. 시스템은 주변기기 정보를 저장한 뒤 매뉴얼 등록 폼 중 '위치 지정하기' 출력한다.
- 15. 액터는 위치를 지정한 뒤 '다음' 버튼을 누른다.
- 16. 시스템은 해당 위치를 저장한 뒤 미리보기와 매뉴얼 등록 폼 중 '저장하기'와 '페이지 추가'를 출력한다.
- 17. 액터는 '저장하기' 버튼을 누른다.
- 18. 시스템은 해당 매뉴얼을 시스템에 저장한 뒤 '매뉴얼 조회하기' 유스케이스 중 2번 항목으로 돌아간다. 

## 대안 흐름(Alternative Flows)
- 3.1. 액터가 첨부파일에 유튜브 링크를 걸면,
    - 시스템은 해당 유튜브 동영상 정보를 가져온다

## 예외흐름(Exception Flows)
- 3.1. 액터가 모델명, 첨부파일 또는 설명을 작성하지 않으면, 
    - 시스템은 필수 입력 항목이 비어있음을 알리는 내용을 출력한다.
- 3.2. 레이아웃을 선택하지 않으면
    - 시스템은 레이아웃을 선택하지 않았음을 알리며, 자유폼으로 진행할 것을 권고하는 내용을 출력한다.
- 3.3. 액터가 '새로운 페이지' 버튼을 누르면,
    - 시스템은 이전에 진행한 내역을 저장하고, '매뉴얼 등록 폼' 유스케이스의 레이아웃부터 진행한다.
