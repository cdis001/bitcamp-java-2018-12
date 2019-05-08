var pageNo = 1,
pageSize = 3,
tbody = $('tbody'),
prevPageLi = $('#prevPage'),
nextPageLi = $('#nextPage'),
currSpan = $('#currPage > span');

//JSON 형식의 데이터 목록 가져오기
function loadList(pn) {

  //$.getJSON(url, function() {});

  $.getJSON('../../app/json/board/list?pageNo=' + pn + '&pageSize=' + pageSize, 
          function (obj){
    // 서버에 받은 데이터 중에서 페이지 번호를 글로벌 변수에 저장한다.
    pageNo = obj.pageNo;

    // TR 태그를 생성하여 테이블 데이터를 갱신한다.
    tbody.html('');
    for (data of obj.list) {
      /*
      var tr = $('<tr>');
      var th = $('<th>');
      th.attr('scope', 'row');
      th.html(data.no);
      tr.append(th);
      */
      
      $('<tr>')
      .append($('<th>').attr('scope', 'row').html(data.no))
      .append($('<td>').append(
              $('<a>').addClass('bit-view-link')
              .attr('href', '#')
              .attr('data-no', data.no)
              .html(data.contents)))
      .append($('<td>').html(data.createdDate))
      .append($('<td>').html(data.viewCount))
      .appendTo(tbody);
    }

    // 현재 페이지의 번호를 갱신한다.
    currSpan.html(String(pageNo));

    // 1페이지일 경우 버튼을 비활성화 한다.
    if (pageNo == 1) {
      prevPageLi.addClass('disabled');
    } else {
      prevPageLi.removeClass('disabled');
    } 

    // 마지막 페이지일 경우 버튼을 비활성화 한다.
    if (pageNo == obj.totalPage) {
      nextPageLi.addClass('disabled');
    } else {
      nextPageLi.removeClass('disabled');
    }
    $(document.body).trigger('loaded-list');
  });

} // loadList()

$('#prevPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo - 1);
});

$('#nextPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo + 1);
});

//페이지를 출력한 후 1페이지 목록을 로딩한다.
loadList(1);

$(document.body).bind('loaded-list', () => {
  
  $('.bit-view-link').click((e) => {
    e.preventDefault();
    window.location.href = 'view.html?no=' + 
    $(e.target).attr('data-no');
  });
});










