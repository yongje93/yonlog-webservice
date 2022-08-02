/**
 * 검색
 */
$(document).on("click", ".btn4search", function () {
    let keyword = $("#keyword").val();
    console.log(keyword);

    let param = {
        "keyword": keyword
    };

    $.ajax({
        type: "POST",
        url: "http://127.0.0.1:8080/api/search",
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(param),
        success: function (data) {
            console.log(data);
        },
        error: function (request, status, error) {
            console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
})
