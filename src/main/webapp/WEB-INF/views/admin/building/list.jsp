<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="buildingAPI" value="/api/building"/>
<c:url var="buildingAssignmentAPI" value="/api/building/assignment"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
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
                <li class="active">Building List</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="page-header">
                <h1>
                    Dashboard
                    <%--<small>--%>
                    <%--<i class="ace-icon fa fa-angle-double-right"></i>--%>
                    <%--overview &amp; stats--%>
                    <%--</small>--%>
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
                                    <form:form modelAttribute="modelSearch" action="${buildingListURL}" id="listForm"
                                               method="GET">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="name">Tên tòa nhà</label>
                                                        <form:input path="name" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="floorArea">Diện tích sàn</label>
                                                        <form:input path="floorArea" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="space-6"></div>
                                                <div class="col-sm-4">
                                                    <div class="space-14"></div>
                                                    <form:select path="district">
                                                        <form:option value="" label="--Chọn quận--"/>
                                                        <form:options items="${districts}"/>
                                                    </form:select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div>
                                                        <label for="ward">Phường</label>
                                                        <form:input path="ward" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div>
                                                        <label for="street">Đường</label>
                                                        <form:input path="street" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <div class="space-6"></div>
                                                    <div class="col-sm-4">
                                                        <div>
                                                            <label for="numberOfBasement">Số tầng hầm</label>
                                                            <form:input path="numberOfBasement"
                                                                        cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div>
                                                            <label for="direction">Hướng</label>
                                                            <form:input path="direction" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div>
                                                            <label for="level">Hạng</label>
                                                            <form:input path="level" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <div class="space-6"></div>
                                                    <div class="col-sm-3">
                                                        <div>
                                                            <label for="rentAreaFrom">Diện tích từ</label>
                                                            <form:input path="rentAreaFrom" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div>
                                                            <label for="rentAreaTo">Diện tích đến</label>
                                                            <form:input path="rentAreaTo" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div>
                                                            <label for="rentCostFrom">Giá thuê từ</label>
                                                            <form:input path="rentCostFrom" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div>
                                                            <label for="rentCostTo">Giá thuê đến</label>
                                                            <form:input path="rentCostTo" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="space-6"></div>
                                                <div class="col-xs-12">
                                                    <div class="col-sm-4">
                                                        <div>
                                                            <label for="managerName">Tên quản lý</label>
                                                            <form:input path="managerName" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div>
                                                            <label for="managerPhone">Điện thoại quản lý</label>
                                                            <form:input path="managerPhone" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="space-14"></div>
                                                    <div class="col-sm-3">
                                                        <sec:authorize access="hasRole('manager')">
                                                            <form:select path="staffId">
                                                                <form:option value="" label="--Chọn nhân viên--"/>
                                                                <form:options items="${staffmaps}"/>
                                                            </form:select>
                                                        </sec:authorize>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="space-6"></div>
                                                <div class="col-xs-12">
                                                    <div class="col-sm-6">
                                                        <label>Loại sản phẩm</label>
                                                        <div class="control-group">
                                                            <form:checkboxes path="buildingTypes" items="${types}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                    <%--Controller will check if is search or find all--%>
                                                <input type="hidden" id="search" name="search" value="true">
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="col-sm-6">
                                                        <button type="button" class="btn btn-primary" id="btnSearch">
                                                            Tìm kiếm
                                                        </button>
                                                    </div>
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
                                        title="Thêm tòa nhà"
                                        onclick="window.location.href = '/admin/building-edit'">
                                    <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-white btn-warning btn-bold"
                                        data-toggle="tooltip" title="Xóa tòa nhà" id="btnDeleteBuilding">
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
                                       requestURI="${buildingListURL}" partialList="true" sort="external"
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
                            <display:column headerClass="text-left" property="modifieddate" title="Ngày"/>
                            <display:column headerClass="text-left" property="name" title="Tên sản phẩm"/>
                            <display:column headerClass="text-left" property="address" title="Địa chỉ"/>
                            <display:column headerClass="text-left" property="managerName" title="Tên quản lý"/>
                            <display:column headerClass="text-left" property="managerPhone" title="Số điện thoại"/>
                            <display:column headerClass="text-left" property="floorArea" title="Diện tích sàn"/>
                            <display:column headerClass="text-left" property="rentCost" title="Giá thuê"/>
                            <display:column headerClass="text-left" property="serviceFee" title="Phí dịch vụ"/>
                            <display:column headerClass="text-left" property="brokerageFee" title="Phí môi giới"/>
                            <display:column headerClass="col-actions" title="Thao tác">
                                <sec:authorize access="hasRole('manager')">
                                    <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Giao tòa nhà"
                                            onclick="assignmentBuilding(${tableList.id})">
                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                    </button>
                                </sec:authorize>

                                <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                        title="Cập nhât tòa nhà"
                                        onclick="window.location.href = '/admin/building-edit-${tableList.id}'">
                                    <i class="ace-icon fa fa-wrench bigger-120"></i>
                                </button>
                                <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                        title="Thông tin tòa nhà"
                                        onclick="window.location.href = '/admin/building-info-${tableList.id}'">
                                    <i class="fa fa-list-alt" aria-hidden="true"></i>
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
<div id="assignmentBuildingModal" class="modal fade" role="dialog">
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
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!--[if !IE]> -->
<%--<script src="assets/js/jquery.2.1.1.min.js"></script>--%>
<!-- <![endif]-->

<script>
    function assignmentBuilding(buildingId) {
        openModalAssignmentBuilding();
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);
        console.log($('#buildingId').val());
    }

    function openModalAssignmentBuilding() {
        $('#assignmentBuildingModal').modal();
    }

    function loadStaff(buildingId) {
        $.ajax({
            type: "GET",
            url: "${buildingAPI}/staffs?buildingId=" + buildingId,
            // data: JSON.stringify(data),
            dataType: "json",
            // contentType: "application/json",
            success: function (response) {
                // console.log('success');
                var row = '';
                $.each(response.data, function (index, item) {
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

    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffIds'] = staffs;
        assignStaff(data)
    });

    function assignStaff(data) {
        $.ajax({
            type: "PUT",
            url: '${buildingAssignmentAPI}',
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
        window.location.reload(true);
    }


    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var buildingIds = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['buildingIds'] = buildingIds;

        if (confirm("Xác nhận xóa?") == true) {
            deleteBuilding(data);
            if (confirm("Đã xóa") == true) {
                window.location.reload(true);
            }
        } else {
            text = "You canceled!";
        }
    });

    function deleteBuilding(data) {
        //call api
        $.ajax({
            type: 'DELETE',
            url: '${buildingAPI}',
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

    $('#btnSearch').click(function (e) {
        //sau khi nhan submit no se vao url ma minh muon
        e.preventDefault();
        $('#listForm').submit();
    });

</script>

</body>
</html>

