function useStyle(n){
                $("#styling-results").attr({"href" : " css/resultView/resultView"+n+".css"})
            }                              
function change_search(n){
                if (n==1){
                    document.getElementById("search-bar").value = "";
                    $("#by_name").addClass("active");
                    $("#by_price").removeClass("active");
                    document.getElementById("min_input").value = 20000;
                    document.getElementById("max_input").value = 20000000;
                    $("#min_input").attr("disabled", true);
                    $("#max_input").attr("disabled", true);
                    $("#min_input").css("background", "#80808070");
                    $("#max_input").css("background", "#80808070");
                    $("#min_input").css("cursor", "no-drop");
                    $("#max_input").css("cursor", "no-drop");
                    $("#search-bar").css("cursor", "");
                    $("#dolar1").css("color", "gray");
                    $("#dolar2").css("color", "gray");
                    $("#search-bar").attr("disabled", false);
                    $("#search-icon").css("color", "black");
                    $("#search-bar").css("background", "");

                    search_by_name();
                }
                if (n==2){
                    $("#min_input").css("background", "");
                    $("#max_input").css("background", "");
                    $("#min_input").css("cursor", "");
                    $("#max_input").css("cursor", "");
                    $("#search-bar").css("cursor", "no-drop");
                    document.getElementById("min_input").value = 20000;
                    document.getElementById("max_input").value = 20000000;
                    $("#by_name").removeClass("active");
                    $("#by_price").addClass("active");
                    document.getElementById("search-bar").value = "";
                    $("#search-bar").attr("disabled", true);
                    $("#search-bar").css("background", "#80808070");
                    $("#search-icon").css("background-color", "transparent");
                    $("#search-icon").css("color", "gray");
                    $("#min_input").attr("disabled", false);
                    $("#max_input").attr("disabled", false);
                    $("#dolar1").css("color", "black");
                    $("#dolar2").css("color", "black");     
                    search_by_price();
                }   
                
                $(document).ready(function(){
                $("#no_res").hide();
                
                $("#x1").click(function(){
                    $("#car1").addClass("deleted");
                    $("#delete1").css("display", "inline-block");
                    $("#car1").hide();
                });
                $("#undelete1").click(function(){
                    $("#car1").removeClass("deleted");
                    $("#delete1").hide();
                    $("#car1").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete2").hide();
                
                $("#x2").click(function(){
                    $("#car2").addClass("deleted");
                    $("#delete2").css("display", "inline-block");
                    $("#car2").hide();
                });
                $("#undelete2").click(function(){
                    $("#car2").removeClass("deleted");
                    $("#delete2").hide();
                    $("#car2").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete3").hide();
                
                $("#x3").click(function(){
                    $("#car3").addClass("deleted");
                    $("#delete3").css("display", "inline-block");
                    $("#car3").hide();
                });
                $("#undelete3").click(function(){
                    $("#car3").removeClass("deleted");
                    $("#delete3").hide();
                    $("#car3").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete4").hide();
                
                $("#x4").click(function(){
                    $("#car4").addClass("deleted");
                    $("#delete4").css("display", "inline-block");
                    $("#car4").hide();
                });
                $("#undelete4").click(function(){
                    $("#car4").removeClass("deleted");
                    $("#delete4").hide();
                    $("#car4").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete5").hide();
                
                $("#x5").click(function(){
                    $("#car5").addClass("deleted");
                    $("#delete5").css("display", "inline-block");
                    $("#car5").hide();
                });
                $("#undelete5").click(function(){
                    $("#car5").removeClass("deleted");
                    $("#delete5").hide();
                    $("#car5").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete6").hide();
                
                $("#x6").click(function(){
                    $("#car6").addClass("deleted");
                    $("#delete6").css("display", "inline-block");
                    $("#car6").hide();
                });
                $("#undelete6").click(function(){
                    $("#car6").removeClass("deleted");
                    $("#delete6").hide();
                    $("#car6").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete7").hide();
                
                $("#x7").click(function(){
                    
                    $("#car7").addClass("deleted");
                    $("#delete7").css("display", "inline-block");
                    $("#car7").hide();
                });
                $("#undelete7").click(function(){
                    $("#car7").removeClass("deleted");
                    $("#delete7").hide();
                    $("#car7").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete8").hide();
                
                $("#x8").click(function(){
                    $("#car8").addClass("deleted");
                    $("#delete8").css("display", "inline-block");
                    $("#car8").hide();
                });
                $("#undelete8").click(function(){
                    $("#car8").removeClass("deleted");
                    $("#delete8").hide();
                    $("#car8").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
            
            $(document).ready(function(){
                $("#delete9").hide();
                
                $("#x9").click(function(){
                    $("#car9").addClass("deleted");
                    $("#delete9").css("display", "inline-block");
                    $("#car9").hide();
                });
                $("#undelete9").click(function(){
                    $("#car9").removeClass("deleted");
                    $("#delete9").hide();
                    $("#car9").show();
                    if (n == 1)
                        search_by_name();
                    else
                        search_by_price();
                })
            })
                
            }
function search_by_name(){
    
var input, cars,car_name,i,counter=0;
 input = document.getElementById("search-bar").value.toUpperCase();
 cars = document.getElementsByClassName("result-box");
 after_delete = document.getElementsByClassName("after-delete");
    
    for (i = 0 ; i < cars.length ; i++){
        car_name = cars[i].getElementsByClassName("car_name")[0].innerHTML.toUpperCase();
        if(car_name.indexOf(input) > -1 && cars[i].className != "result-box deleted"){
            cars[i].style.display = "";
            
        }else{
            cars[i].style.display = "none";
            counter = counter +1 ;
        }
            
        if (counter == cars.length){
            document.getElementById("no_res").style.display = "block";
        }
        else{
            document.getElementById("no_res").style.display = "none";
        }
    }
}
function search_by_price(){
    
var min_input, max_input, cars,car_price,i,counter=0;
 min_input = document.getElementById("min_input").value;
 max_input = document.getElementById("max_input").value;
 cars = document.getElementsByClassName("result-box");

    for (i = 0 ; i < cars.length ; i++){
        car_price = Number(cars[i].getElementsByClassName("price")[0].id);
        if(car_price >= min_input && car_price <= max_input && cars[i].className != "result-box deleted"){
            cars[i].style.display = "";
            
        }else{
            cars[i].style.display = "none";
            counter = counter +1 ;
        }
        if (counter == cars.length){
            document.getElementById("no_res").style.display = "block";
        }
        else{
            document.getElementById("no_res").style.display = "none";
        }
    }

}