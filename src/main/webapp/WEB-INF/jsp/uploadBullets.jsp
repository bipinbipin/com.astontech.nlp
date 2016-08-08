<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file = "includes/header.jsp" %>
<%@include file = "includes/navbar.jsp" %>


<style>

    .jumbotron
    {
        border: 2px solid #ff8400;
    }

    .btn-group-vertical .btn
    {
        border:     1px solid white;
        text-align: left;
    }

    .headerTitle
    {
        margin-left:   75px;
        margin-bottom: -20px;
        z-index:       50;
    }

    .headerTitle h1
    {
        color:       #0776A0;
        font-weight: bold;

    }

    #collapse1
    {
        color: #0776A0;
    }

    #bulletTable .badge
    {
        background-color: #ff8400 !important;
    }

</style>


<div class = "container-fluid">
    <div class = "row headerTitle">
        <h1>Upload New Bullets</h1>
    </div>

    <div class = "jumbotron">
        <form:form method = "post" commandName = "file">

        </form:form>

        <div class = "row">
            <div class = "col-lg-2 col-md-4 col-sm-4 col-xs-4 table-responsive">
                <div class = "panel panel-default">
                    <div class = "panel-heading">
                        <h3 class = "panel-title text-center">Current Bullet Count</h3>
                    </div>
                    <div class = "panel-body">
                        <table class = "table" id = "bulletTable">
                            <tbody>
                            <tr>
                                <td>
                                    Programming <span class = "badge pull-right">57</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Database <span class = "badge pull-right">114</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Web Services <span class = "badge pull-right">23</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Leadership <span class = "badge pull-right">67</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    DevOps <span class = "badge pull-right">12</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <!-- Trigger the modal with a button -->
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

                        <!-- Modal -->
                        <div id="myModal" class="modal fade" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Upload File</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class = "col-12">
                                            <div class = "input-group">
                                                <label class = "input-group-btn">
                    <span class = "btn btn-primary">
                        Browse&hellip; <input type = "file" style = "display: none;" multiple>
                    </span>
                                                </label>
                                                <input type = "text" class = "form-control" readonly>
                                            </div>
                                            <span class = "help-block">Select the folder where the resumes are located</span>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="col-12">
                                                <label class="btn btn-block btn-primary">
                                                    Upload<input type="file" style="display: none;">
                                                </label>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class = "col-lg-10">
                <div class = "panel panel-default">
                    <div class = "panel-heading">
                        <h3 class = "panel-title text-center">
                            <a data-toggle="collapse" href="#collapse1">Choose File To Upload</a>
                        </h3>
                    </div>
                    <div class = "panel-body collapse panel-collapse" id="collapse1">
                        <div class = "col-lg-4 col-sm-4">
                            <div class = "input-group">
                                <label class = "input-group-btn">
                    <span class = "btn btn-primary">
                        Browse&hellip; <input type = "file" style = "display: none;" multiple>
                    </span>
                                </label>
                                <input type = "text" class = "form-control" readonly>
                            </div>
                            <span class = "help-block">Select the folder where the resumes are located</span>
                        </div>
                        <div class = "col-lg-6 col-sm-6">
                            <label class = "btn btn-block btn-primary">
                                Browse&hellip; <input type = "file" style = "display: none;">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>


    <%--<input type="file" name="file" class="btn btn-default"/>--%>

    <%--<input type="submit" value="Upload" class="btn btn-default"/>--%>

    <script>
        $(function ()
        {

            // We can attach the `fileselect` event to all file inputs on the page
            $(document).on('change', ':file', function ()
            {
                var input = $(this),
                        numFiles = input.get(0).files ? input.get(0).files.length : 1,
                        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                input.trigger('fileselect', [numFiles, label]);
            });

            // We can watch for our custom `fileselect` event like this
            $(document).ready(function ()
            {
                $(':file').on('fileselect', function (event, numFiles, label)
                {

                    var input = $(this).parents('.input-group').find(':text'),
                            log = numFiles > 1 ? numFiles + ' files selected' : label;

                    if (input.length)
                    {
                        input.val(log);
                    }
                    else
                    {
                        if (log) alert(log);
                    }

                });
            });

        });
    </script>

</div>
