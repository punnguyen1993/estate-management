<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
<c:url var="buildingEditURL" value="/admin/building-edit"/>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Building edit</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<form class="form-horizontal" role="form" id = "formEdit">--%>
                    <form:form modelAttribute="modelAdding" action="${buildingEditURL}"  id="formEdit" method="POST">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name"> Tên sản phẩm </label>
                                <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Quận </label>
                            <div class="col-sm-9">
                                <form:select path="district">
                                    <form:option value="" label="--Chọn quận--"/>
                                    <form:options items="${districts}"/>
                                </form:select>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward"> Phường </label>
                            <div class="col-sm-9">
                                <%--<input type="text" id="ward" class="col-xs-10 col-sm-5" name="ward" />--%>
                                    <form:input path="ward" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street"> Đường </label>
                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="structure"> Kết cấu </label>
                            <div class="col-sm-9">
                                <form:input path="structure" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement"> Số tầng hầm </label>
                            <div class="col-sm-9">
                                <form:input path="numberOfBasement" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="floorArea"> Diện tích sàn </label>
                            <div class="col-sm-9">
                                <form:input path="floorArea" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="direction"> Hướng </label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="level"> Hạng </label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentAreas"> Diện tích thuê </label>
                            <div class="col-sm-9">
                                    <form:input path="rentAreas" cssClass="form-control"/>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="descriptionOfArea"> Mô tả diện tích </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<form:input path="descriptionOfArea" cssClass="form-control"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentCost"> Giá thuê </label>
                            <div class="col-sm-9">
                                <form:input path="rentCost" cssClass="form-control"/>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="descriptionOfPrice"> Mô tả giá </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<form:input path="descriptionOfPrice" cssClass="form-control"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="serviceFee"> Phí dịch vụ </label>
                            <div class="col-sm-9">
                                <form:input path="serviceFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="carFee"> Phí ô tô </label>
                            <div class="col-sm-9">
                                <form:input path="carFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="motoFee"> Phí mô tô </label>
                            <div class="col-sm-9">
                                <form:input path="motoFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="overTimeFee"> Phí ngoài giờ </label>
                            <div class="col-sm-9">
                                <form:input path="overTimeFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="electricityFee"> Tiền điện </label>
                            <div class="col-sm-9">
                                <form:input path="electricityFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="deposit"> Đặt cọc </label>
                            <div class="col-sm-9">
                                <form:input path="deposit" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="payment"> Thanh toán </label>
                            <div class="col-sm-9">
                                <form:input path="payment" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentTime"> Thời hạn thuê </label>
                            <div class="col-sm-9">
                                <form:input path="rentTime" cssClass="form-control"/>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="decorateTime"> Thời gian trang trí </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<form:input path="decorateTime" cssClass="form-control"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerName"> Tên quản lý </label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerPhone"> SĐT Quản lý </label>
                            <div class="col-sm-9">
                                <form:input path="managerPhone" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="brokerageFee"> Phí môi giới </label>
                            <div class="col-sm-9">
                                <form:input path="brokerageFee" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="space-6"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="buildingTypes"> Loại sản phẩm </label>
                            <div class="col-sm-9">
                                <div class="control-group">
                                    <form:checkboxes path="buildingTypes" items="${types}"/>
                                </div>
                            </div>
                        </div>
                        <div class="space-6"></div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label no-padding-right" for="brokerageFee"></label>
                            <div class="col-sm-8">
                                <c:if test="${!isInfo}">
                                    <button type="button" class="btn btn-primary" id="btnAddBuilding" >
                                            ${buttonName}
                                        <input type="hidden" id="id" name="id" value="${modelAdding.id}">

                                    </button>
                                    <button type="button" class="btn btn-danger">Hủy</button>
                                </c:if>
                            </div>
                        </div>
                    </form:form>
                    <%--</form>--%>
                </div>
            </div><!-- /.row -->
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<!--[if !IE]> -->
<!-- jquery nên để trước function vì html biên dịch code nó chạy từ trên xuống -->
<script src="assets/js/jquery.2.1.1.min.js"></script>
<!-- <![endif]-->
<script>
    function getRedirectUrl(){
        var newloc = "${buildingListURL}";
        window.location.replace(newloc);

    }

    //ajax call api add building$
    $('#btnAddBuilding').click(function(e){
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();

        $.each(formData, function(index, v){
            if(v.name == 'buildingTypes'){
                buildingTypes.push(v.value);
            }else{
                data[""+v.name+""] = v.value;
            }
        });
        data['buildingTypes'] = buildingTypes;

        $.ajax({
            type: 'POST',
            url: '${buildingAPI}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function(response){
                console.log('success');
            },
            error: function(response){
                console.log('failed');
                console.log(response);
            }
        });
        if (confirm("Quay lại danh sách tòa nhà?") == true) {
            getRedirectUrl();
        }
    });
</script>
</body>
</html>

