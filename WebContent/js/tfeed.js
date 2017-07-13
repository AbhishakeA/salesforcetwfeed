/*This function is used to hide all other table rows but the ones that matched the search paramenter in Input field
 * The input field data is retrived by element ID and is compared against all the data on page
 * The one matched will not be hidden and rest will be hidden making search functionlity effective and faster*/
function mySearch() {
          
           var input, filter, table, tr, td, i;
           input = document.getElementById("myInput");
           filter = input.value.toUpperCase();
           table = document.getElementById("feedTable");
           tr = table.getElementsByTagName("tr");
           
           for (i = 0; i < tr.length; i++) {
             td = tr[i].getElementsByTagName("td")[2];
             if (td) {
               if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                 tr[i].style.display = "";
               } else {
                 tr[i].style.display = "none";
               }
             }       
           }
           
         }
     
/*This function is called onload of JSP after displaying all status
 * and waits for 60 seconds before it refreshes the top 10 latest tweets*/     
function reLoad() {
         
             // your function code here
             //setTimeout(function(){ document.location.href = '${pageContext.request.contextPath}/TwitterFeed'; }, 3000);
            sleep(1000);
         	document.location.href = '${pageContext.request.contextPath}/TwitterFeed';
         	return "success";
             
 }
         
  
