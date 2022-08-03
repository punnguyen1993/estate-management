<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="customerAPI" value="/api/customer"/>
<c:url var="customerAssignmentAPI" value="/api/customer/assignment"/>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Customer List</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="page-header">
                <h1>
                    Dashboard
                    <%--<small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>--%>
                </h1>
            </div><!-- /.page-header -->

            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="form-horizontal">
                    <div class="col-xs-12">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Tìm kiếm</h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <%--form rieng cua spring ho tro nhieu hon(vidu: co ho tro modelAttribute, ben html cung co form--%>
                                    <form:form modelAttribute="modelSearch" action="${customerListURL}" id="listForm"
                                               method="GET">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="fullName">Tên khách hàng</label>
                                                        <form:input path="fullName" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="phone">Di động</label>
                                                        <form:input path="phone" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="email">Email</label>
                                                        <form:input path="email" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="space-6"></div>
                                                <div class="col-sm-4">
                                                    <sec:authorize access="hasRole('manager')">
                                                        <form:select path="staffId">
                                                            <form:option value="" label="--Nhân viên phụ trách--"/>
                                                            <form:options items="${staffmaps}"/>
                                                        </form:select>
                                                    </sec:authorize>

                                                </div>
                                            </div>
                                                <%--Controller will check is search or find all--%>
                                            <input type="hidden" id="search" name="search" value="true">
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="space-8"></div>
                                                <div class="col-sm-6">
                                                <button type="button" class="btn btn-primary" id="btnSearch">
                                                    Tìm kiếm
                                                </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="pull-right">
                                    <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                             title="Thêm khách hàng"
                                            onclick="window.location.href = '/admin/customer-edit'">
                                        <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                    </button>
                                <button class="btn btn-white btn-warning btn-bold" data-toggle="tooltip"
                                        title="Xóa xóa khách hàng" id="btnDeleteCustomer" >
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </button>
                                <div class="space-6"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">


                    <div class="table-responsive">
                        <display:table name="tableModel.listResult" cellspacing="0" cellpadding="0"
                                       requestURI="${customerListURL}" partialList="true" sort="external"
                                       size="${tableModel.totalItems}" defaultsort="2" defaultorder="ascending"
                                       id="tableList" pagesize="${tableModel.maxPageItems}"
                                       export="false"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                            headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>

                            </display:column>
                            <display:column headerClass="text-left" property="fullName" title="Tên"/>
                            <display:column headerClass="text-left" property="staffName" title="Nhân viên quản lý"/>
                            <display:column headerClass="text-left" property="phone" title="Di động"/>
                            <display:column headerClass="text-left" property="email" title="Email"/>
                            <display:column headerClass="text-left" property="demand" title="Nhu cầu"/>
                            <display:column headerClass="text-left" property="createdBy" title="Người nhập"/>
                            <display:column headerClass="text-left" property="createdDate" title="Thao tác"/>
                            <display:column headerClass="col-actions" title="Thao tác">
                                <sec:authorize access="hasRole('manager')">
                                    <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                            title="Giao khách hàng"
                                            onclick="assignmentCustomer(${tableList.id})">
                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                    </button>
                                </sec:authorize>

                                <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                        title="Cập nhât khách hàng"
                                        onclick="window.location.href = '/admin/customer-edit-${tableList.id}'">
                                    <i class="ace-icon fa fa-wrench bigger-120"></i>
                                </button>
                            </display:column>
                        </display:table>
                    </div>
                </div>
            </div><!-- /.row -->
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<div id="assignmentCustomerModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered" id="staffList">
                    <thead>
                    <tr>
                        <td>Chọn nhân viên</td>
                        <td>Tên nhân viên</td>
                    </tr>
                    </thead>

                    <tbody>
                    <%-- client side rendering, function loadstaff() bên dưới chỗ ajax --%>
                    </tbody>

                </table>
                <input type="hidden" id="customerId" name="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="getCurrentLocation()"
                                                    id="btnAssignCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!--[if !IE]> -->
<%--<script src="assets/js/jquery.2.1.1.min.js"></script>--%>
<!-- <![endif]-->

<script>
    function getCurrentLocation(){
        window.location.reload(true);

    }

    function assignmentCustomer(customerId) {
        openModalAssignmentCustomer();
        loadStaff(customerId);
        $('#customerId').val(customerId);
        console.log($('#customerId').val());
    }

    function openModalAssignmentCustomer() {
        $('#assignmentCustomerModal').modal();
    }

    function loadStaff(customerId) {
        $.ajax({
            type: "GET",
            url: "${customerAPI}/staffs?customerId=" + customerId ,
            // data: JSON.stringify(data),
            dataType: "json",
            // contentType: "application/json",
            success: function (response) {
                // console.log('success');
                var row = '';
                $.each(response.data, function (index, item) { //chua hieu cho item nay lắm
                    row += '<tr>';
                    row += '<td class="text-center"><input type="checkbox" value =' + item.staffId + ' id="checkbox_' + item.staffId + '" class="check-box-element" ' + item.check + '/></td>';
                    row += '<td class="text-center">' + item.fullName + '</td>';
                    row += '</tr>';
                });
                $('#staffList tbody').html(row);
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    }

    $('#btnAssignCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        data['customerId'] = $('#customerId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffIds'] = staffs;
        assignStaff(data)
    });

    function assignStaff(data) {
        $.ajax({
            type: "PUT",
            url: '${customerAssignmentAPI}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    }

    $('#btnDeleteCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        var customerIds = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['customerIds'] = customerIds;
        if (confirm("Xác nhận xóa?") == true) {
            deleteCustomer(data);
            if (confirm("Đã xóa!") == true) {
                getCurrentLocation();
            }
        } else {
            text = "You canceled!";
        }
    });

    function deleteCustomer(data) {
        //call api
        $.ajax({
            type: 'DELETE',
            url: '${customerAPI}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('success');
                // window.location.reload(true);
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    }

    $('#btnSearch').click(function (e) {
        //sau khi nhan submit no se vao url ma minh muon
        e.preventDefault();
        $('#listForm').submit();
    });

</script>

</body>
</html>

