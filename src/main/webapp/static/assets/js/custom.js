$("document").ready(function(){
    // $("table tbody tr.card-toggle ").click(function(){
    // $(this).closest("tr").next('tr').toggleClass( "d-none");
    // $(this).closest("tr").next('tr').toggleClass( "card-close");
    // $(this).closest("tr").find('.delete-toggle').toggleClass("d-none");
    // $(this).closest("tr").find(".arrow_head").toggleClass("openclose");
    // $(this).closest("tr").toggleClass("card-start");

    // });
    // $("table tbody tr .arrow_head.openclose").click(function(){
    // $(this).closest("tr").find(".delete_btn").hide();

    // });

    // $("table tbody tr .menu_img").click(function(){
     
    // $(this).closest("td").find(".delete_btn").toggleClass("d-none");

    // });


    $(".panel-heading").click(function(){
 
    	 if ($(this).find('img.img.img-thumbnail.img-responsive.arrow_head').hasClass('openclose')) {
    	        $(this).find('img.img.img-thumbnail.img-responsive.arrow_head').toggleClass('openclose');
    	      }else {
    	        $(".panel-heading").find('img.img.img-thumbnail.img-responsive.arrow_head').removeClass('openclose');
    	        $(this).find('img.img.img-thumbnail.img-responsive.arrow_head').addClass('openclose');

    	      }

    	      if (!($(this).find('.content-menu-btn').hasClass('d-none'))) {
    	        $(this).find('.content-menu-btn').toggleClass('d-none');
    	      }else {
    	        $(".panel-heading").find('.content-menu-btn').addClass('d-none');
    	        $(this).find('.content-menu-btn').removeClass('d-none');
    	      }
 });

    // filter

    // $("#arinput").change(function(){
    // if ($('#arinput').is(":checked"))
    // {
    // var value="ar";
    // $("tbody tr ").filter(function() {
    // $(this).toggle($(this).text().toLowerCase().indexOf(value) > 1);
    // });
    // }
        
    // });
    // $("#vrinput").change(function(){
    // if ($('#vrinput').is(":checked"))
    // {
    // var value="vr";
    // $("tbody tr ").filter(function() {
    // $(this).toggle($(this).text().toLowerCase().indexOf(value) > 1);
    // });
    // }
        
    // });
    // $("#training").change(function(){
    // if ($('#training').is(":checked"))
    // {
    // var value="training";
    // $("tbody tr ").filter(function() {
    // $(this).toggle($(this).text().toLowerCase().indexOf(value) > 1);
    // });
    // }
        
    // });
    // $("#evaluation").change(function(){
    // if ($('#evaluation').is(":checked"))
    // {
    // var value="evaluation";
    // $("tbody tr ").filter(function() {
    // $(this).toggle($(this).text().toLowerCase().indexOf(value) > 1);
    // });
    // }
        
    // });

        
   
});

$(document).ready(function(){
            
  $(document).on('click', '.delete_btn', function(e){
	  var that = this;
      var id = $(this).data('id');
      var parent = $(this).parent("td").parent("tr");
      var parent2 = $(this).parent("td").parent("tr").next("tr");
      var token = $("meta[name='csrf-token']").attr("content");
  swal({
  title: "Archive Session",
  text: "Are you sure you wish to archive this session ? You can restore the session from archives later.",
  // icon: "warning",
  buttons: ["Cancel", "ARCHIVE"],
  dangerMode: true,
  })
  .then((willDelete) => {
      if (willDelete) {
    	  window.location.href=$(that).attr('href');
  }
  });
      e.preventDefault();
  });
  $(document).on('click', '.restore_btn', function(e){
	  var that = this;
    var id = $(this).data('id');
    var parent = $(this).parent("td").parent("tr");
    var parent2 = $(this).parent("td").parent("tr").next("tr");
    var token = $("meta[name='csrf-token']").attr("content");
swal({
title: "Restore Session",
text: "Are you sure you wish to restore this session ? ",
// icon: "warning",
buttons: ["Cancel", "RESTORE"],
dangerMode: true,
})
.then((willDelete) => {
    if (willDelete) {
    	window.location.href=$(that).attr('href');

}
});
    e.preventDefault();
});
  
});

$("#filter_toggle").click(function(){
  $(".filter_holder").toggleClass("d-none");
});


// filter image chnaged

$(".filter-button").click(function(){
  var a=$(this).find("img").attr("src");
  var parts = a.split("/");
var last_part = parts[parts.length-1];
// alert(last_part);

if(last_part=="check-box-checked.png"){
$(this).find("img").attr("src","assets/img/dashboard/check-box-unchecked.png")
}else{
$(this).find("img").attr("src","assets/img/dashboard/check-box-checked.png")

}
});




// filter


$(document).ready(function () {

  $(".filter-button").click(function () {
      $(this).addClass("active");
      var value = $(this).attr('data-filter');

      if (value == "all") {
          // $('.filter').removeClass('hidden');
          $('.filter').show('1000');
      } else {
          // $('.filter[filter-item="'+value+'"]').removeClass('hidden');
          // $(".filter").not('.filter[filter-item="'+value+'"]').addClass('hidden');
          input = $("#" + value).prop("checked");
          if (input === true) {
              $("#" + value).prop("checked", false);
              $(this).removeClass("active");
          } else {
              $("#" + value).prop("checked", true);
          }

          $(".filter").hide('3000');
          $("input").each(function () {
              if ($(this).prop("checked")) {
                  value = $(this).val();
                  $('.filter').filter('.' + value).show('3000');
              }
          });
          // $(".filter").not('.' + value).hide('3000');
          // $('.filter').filter('.' + value).show('3000');
      }
  });

  if ($(".filter-button").removeClass("active")) {
      $(this).removeClass("active");
  }
  $(this).addClass("active");

});


// search filter
$(document).ready(function(){
    $("#searchInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("div.panel").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });
$(document).ready(function(){
    $("#searchInputNormal").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("table tbody tr").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });



  $(document).ready(function() {
    
    function exportTableToCSV($table, filename) {
    
      var $rows = $table.find('tr:has(td)'),
    
        // Temporary delimiter characters unlikely to be typed by keyboard
        // This is to avoid accidentally splitting the actual contents
        tmpColDelim = String.fromCharCode(11), // vertical tab character
        tmpRowDelim = String.fromCharCode(0), // null character
    
        // actual delimiter characters for CSV format
        colDelim = '","',
        rowDelim = '"\r\n"',
    
        // Grab text from table into CSV formatted string
        csv = '"' + $rows.map(function(i, row) {
          var $row = $(row),
            $cols = $row.find('td');
    
          return $cols.map(function(j, col) {
            var $col = $(col),
              text = $col.text();
    
            return text.replace(/"/g, '""'); // escape double quotes
    
          }).get().join(tmpColDelim);
    
        }).get().join(tmpRowDelim)
        .split(tmpRowDelim).join(rowDelim)
        .split(tmpColDelim).join(colDelim) + '"';
    
      // Deliberate 'false', see comment below
      if (false && window.navigator.msSaveBlob) {
    
        var blob = new Blob([decodeURIComponent(csv)], {
          type: 'text/csv;charset=utf8'
        });
    
        // Crashes in IE 10, IE 11 and Microsoft Edge
        // See MS Edge Issue #10396033
        // Hence, the deliberate 'false'
        // This is here just for completeness
        // Remove the 'false' at your own risk
        window.navigator.msSaveBlob(blob, filename);
    
      } else if (window.Blob && window.URL) {
        // HTML5 Blob
        var blob = new Blob([csv], {
          type: 'text/csv;charset=utf-8'
        });
        var csvUrl = URL.createObjectURL(blob);
    
        $(this)
          .attr({
            'download': filename,
            'href': csvUrl
          });
      } else {
        // Data URI
        var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);
    
        $(this)
          .attr({
            'download': filename,
            'href': csvData,
            'target': '_blank'
          });
      }
    }
    
    // This must be a hyperlink
    $(".export").on('click', function(event) {
      // CSV
      var args = [$('#dvData>table'), 'session_exported.csv'];
    
      exportTableToCSV.apply(this, args);
    
      // If CSV, don't do event.preventDefault() or return false
      // We actually need this to be a typical hyperlink
    });
    $(".traineeexport").on('click', function(event) {
      // CSV
      var args = [$('#dvData>table'), 'trainee_exported.csv'];
    
      exportTableToCSV.apply(this, args);
    
      // If CSV, don't do event.preventDefault() or return false
      // We actually need this to be a typical hyperlink
    });
    });



    
$(document).ready(function(){
            
  $(document).on('click', '.admin-del', function(e){
	  e.preventDefault();
      var that = this;
	  swal({
	      title: "Delete Admin",
	      text: "Are you sure you wish to delete this admin ? ",
	      // icon: "warning",
	      buttons: ["Cancel", "Delete"],
	      dangerMode: true,
	    })
	    .then((willDelete) => {
	      if (willDelete) {
	    	  window.location.href=$(that).attr('href');
	      }
	    });
  });
});