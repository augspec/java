$(function(){

    var ul = $('.uploadVerify ul');

    $('#drop a').click(function(){
        // Simulate a click on the file input button
        // to show the file browser dialog
        $(this).parent().find('input').click();
    });
    var currentLine = null;

    // Initialize the jQuery File Upload plugin
    $('.uploadVerify').fileupload({

        // This element will accept file drag/drop uploading
        dropZone: $('#drop'),

        // This function is called when a file is added to the queue;
        // either via the browse button, or via drag/drop:
        add: function (e, data) {

            var tpl = $('<li class="working"><input type="text" value="0" data-width="48" data-height="48"'+
                ' data-fgColor="#0192ff" data-readOnly="1" data-bgColor="#b2deff" /><p></p><span></span></li>');

            // Append the file name and file size
            tpl.find('p').text(data.files[0].name)
                         .append('<br/><i class="file-size">' + formatFileSize(data.files[0].size) + '</i>');

            // Add the HTML to the UL element
            data.context = tpl.appendTo(ul);
            currentLine = tpl;

            // Initialize the knob plugin
            tpl.find('input').knob();

            // Listen for clicks on the cancel icon
            tpl.find('span').click(function(){

                if(tpl.hasClass('working')){
                    jqXHR.abort();
                }

                //Xoa dong khi nhan vao tick mau xanh
//                tpl.fadeOut(function(){
//                    tpl.remove();
//                });

            });

            // Automatically upload the file once it is added to the queue
            var jqXHR = data.submit();
        },

        progress: function(e, data){

            // Calculate the completion percentage of the upload
        	
            var progress = parseInt(data.loaded / data.total * 100, 10);

            // Update the hidden input field and trigger a change
            // so that the jQuery knob plugin knows to update the dial
            data.context.find('input').val(progress).change();

            if(progress == 100){
                data.context.removeClass('working');
            }
        },
        
        done: function(e, data){
        	var result = data.result;
        	if(result.message == 'OK'){
                message("Chữ ký hợp lệ!");
            	currentLine.find('span').append("<a target='_blank' href='TransactionLogServlet?id=download&file=" + result.file + "'><i class='fa fa-download'></i></a>");
        	} else{
        		warning("Chữ ký không hợp lệ! " + result.message);
            	currentLine.find('span').append("<i clas='fa fa-close'></i>");
        	}
        },

        fail:function(e, data){
            // Something has gone wrong!
            data.context.addClass('error');
        }

    });


    // Prevent the default action when a file is dropped on the window
    $(document).on('drop dragover', function (e) {
        e.preventDefault();
    });

    // Helper function that formats the file sizes
    function formatFileSize(bytes) {
        if (typeof bytes !== 'number') {
            return '';
        }

        if (bytes >= 1000000000) {
            return (bytes / 1000000000).toFixed(2) + ' GBs';
        }

        if (bytes >= 1000000) {
            return (bytes / 1000000).toFixed(2) + ' MBs';
        }

        return (bytes / 1000).toFixed(2) + ' KBs';
    }

});