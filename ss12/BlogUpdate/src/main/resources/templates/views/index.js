$('#searchButton').click(function(){
    const author=document.getElementById("author").value;

    $.ajax({
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        url:`http://localhost:8080/api/posts/${author}`,
        type : "GET",
        data:{author:author},
        success:function (data){
            console.log(data);
        },
        error: function(err){
            alert("Lỗi")
            console.log(err);
        }
    })
})
