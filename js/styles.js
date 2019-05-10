$(document).on("click", "a.mask-select", function() {
    var a = $(this).closest(".left-down");
    $(a).find("a.mask-select").addClass("d-none");
    $(a).find(".form-group.select").removeClass("opened");
    $(a).find(".left-select").fadeToggle();
});

$(document).on("click", ".form-group.select>input", function() {
    $(this).parent().addClass("opened");
    var a = $(this).closest(".left-down");
    $(a).find(".left-select").fadeToggle();
    $(a).find("a.mask-select").toggleClass("d-none");
});

$(document).on("click", ".left-select li a", function() {
    var a = $(this).closest(".left-down");
    $(a).find(".form-group.select.opened input").val($(this).text());
    $(a).find(".form-group.select").removeClass("opened");
    $(a).find(".left-select").fadeToggle();
    $(a).find("a.mask-select").addClass("d-none");
});

$(document).on("click", "span[type='checkbox']", function() {
    $(this).toggleClass("checked");
    if ($(this).hasClass("checked")) {
        $(this).next().prop("checked", true);
    } else {
        $(this).next().prop("checked", false);
    }
});

$(document).on("click", "span[type='radio']", function() {
    $("[name=" + $(this).next().attr("name") + "]").prev().removeClass("checked");
    $(this).addClass("checked");
    $(this).next().click();
});

$(document).on("click", "ul.list-unstyled li a", function() {
    $(this).closest("ul").children().removeClass("active");
    $(this).parent().addClass("active").removeClass("new");
});

$(document).on("touchstart", ".patients.scroll", function(e) {
    startY = e.originalEvent.changedTouches[0].pageY;
});
$(document).on("touchmove", ".patients.scroll", function(e) {
    moveEndY = e.originalEvent.changedTouches[0].pageY;
    if (moveEndY - startY > 100) {
        $(".loadstart").removeClass("d-none");
    }
});
$(document).on("touchend", ".patients.scroll", function(e) {
    moveEndY = e.originalEvent.changedTouches[0].pageY;
    if (moveEndY - startY > 100) {
        $(".loadstart").addClass("loading");
        setTimeout(function() {
            $(".loadstart").addClass("d-none");
            $(".loadstart").removeClass("loading");
        }, 2000);
    }
});

function getJsonLength(jsonData) {
    var length = 0;
    for (var i in jsonData) {
        length++;
    }
    return length;
}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function nothing() {
    $(".data").each(function() {
        if ($(this).height() <= 1) {
            $(this).addClass("nothing");
        } else {
            $(this).removeClass("nothing");
        }
    });
}
