$(document).ready(function(){
    $("#meme2").insertBefore("#meme1");
    $("#meme3").insertBefore("bottom-caption");
    $("#img1").hide();
    $("#top-text").keyup(function(){
        $txt = $("#top-text");
        $("#top-caption").html($txt.val());
    })

    $("#bottom-text").keyup(function(){
        $txt = $("#bottom-text");
        $("#bottom-caption").html($txt.val());
    })

    $("#image-url").keyup(function(){
        $url = $("#image-url").val();
        $("#img1").attr("src", $url);
        $("#img1").show();
    })

    $(document).keydown(function() {
        $div = $("#meme3");
        if (event.which == 37) { //left
            $div.attr("style", "margin-left:50px;margin-right:100px;margin-top:100px;margin-bottom:100px");
        }
        if (event.which == 38) { //up
            $div.attr("style", "margin-left:100px;margin-right:100px;margin-top:50px;margin-bottom:100px");
        }
        if (event.which == 39) { //right
            $div.attr("style", "margin-left:100px;margin-right:50px;margin-top:100px;margin-bottom:100px");
        }
        if (event.which == 40) { //down
            $div.attr("style", "margin-left:100px;margin-right:100px;margin-top:100px;margin-bottom:50px");
        }
    })
});