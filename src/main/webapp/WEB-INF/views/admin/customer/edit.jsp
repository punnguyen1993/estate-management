<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerAPI" value="/api/customer"/>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<c:url var="transactionAPI" value="/api/customer/transaction"/>
<c:url var="customerListURL" value="/admin/customer-list"/>
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
                <li class="active">Customer Edit</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<form class="form-horizontal" role="form" id = "formEdit">--%>
                    <form:form modelAttribute="modelAdding" action="${customerEditURL}"  id="formEdit" method="POST">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="fullName"> Tên đầy đủ </label>
                            <div class="col-sm-9">
                                    <form:input path="fullName" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="phone"> Số điện thoại </label>
                            <div class="col-sm-9">
                                <form:input path="phone" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="email"> Email </label>
                            <div class="col-sm-9">
                                <form:input path="email" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="companyName"> Tên công ty </label>
                            <div class="col-sm-9">
                                <form:input path="companyName" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="demand"> Nhu cầu </label>
                            <div class="col-sm-9">
                                <form:input path="demand" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="note"> Ghi chú </label>
                            <div class="col-sm-9">
                                <form:input path="note" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="space-6"></div>
                        <div class="form-group">
                            <div class="space-6"></div>
                            <div class="col-sm-8 text-center" >
                                <button type="button" class="btn btn-outline-warning" id="btnAddCustomer" >
                                    ${buttonName}
                                    <input type="hidden" id="customerId" name="id" value="${modelAdding.id}">
                                </button>
                            </div>
                        </div>
                    </form:form>
                    <%--</form>--%>
                </div>
            </div><!-- /.row -->

            <div class="row">
                <div class="col-xs-12">
                    <c:forEach var="type" items="${transactions}">
                        <label for=>${type.name}</label>
                        <a onclick="addTransaction('${type.code}')">
                            <i class="menu-icon fa fa-plus"></i>
                        </a>
                        <input type="hidden" id="cusId" name="cusId" value="${customerId}">
                        <table id="transactrion_${type.code}" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Ngày tạo</th>
                                    <th>Ghi chú</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${type.transactionDTO}">
                                    <tr>
                                        <th>${item.createdDate}</th>
                                        <th>${item.note}</th>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <th></th>
                                    <th>
                                        <%--<c:set scope="request" var="greeting" value="transactionNote_${type.code}" />--%>
                                        <%--Greeting: <c:out value="${greeting}"/>--%>
                                        <input type="text" id="transactionNote_${type.code}" class="col-xs-10 col-sm-5" name="transactionNote_${type.code}"/>
                                    </th>
                                </tr>
                            </tbody>
                        </table>
                    </c:forEach>

                    <c:if test="${customerId != null}">
                        <div class="space-6"></div>
                        <div class="col-xs-12 col-sm-4">
                            <select name="code00" id="code00">
                                <option value="">--Thêm loại giao dịch--</option>
                                <c:forEach var="item" items="${transactiontypes}">
                                    <option value="${item.key}">${item.value}</option>
                                </c:forEach>
                            </select>
                            <a onclick="addTransactionType()">
                                <i class="menu-icon fa fa-plus"></i>
                            </a>
                            <input type="hidden" id="cusId00" name="cusId00" value="${customerId}">
                            <table id="transactrion_00" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Ghi chú</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>
                                        <input type="text" id="transactionNote_00" class="col-xs-10 col-sm-5"
                                               name="ward"/>
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<!-- jquery nên để trước function vì html biên dịch code nó chạy từ trên xuống -->
<script src="assets/js/jquery.2.1.1.min.js"></script>
<!-- <![endif]-->
<script>
    function getCustomerListLocation(){
        var newloc = "${customerListURL}";
        window.location.replace(newloc);

    }
    //ajax call api add building$
    $('#btnAddCustomer').click(function(e){
        e.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();

        $.each(formData, function(index, v){
                data[""+v.name+""] = v.value;
        });
        var customerId = $('#customerId').val();

        $.ajax({
            type: (!customerId) ? 'POST': 'PUT',
            url: (!customerId) ? "${customerAPI}" : "${customerAPI}?customerId=" + customerId,
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
        if (confirm("Quay lại danh sách khách hàng?") == true) {
            getCustomerListLocation();
        }
    });
    function addTransaction(code){
        var data = {};
        var note = $('#transactionNote_' + code).val();
        data['customerId'] = $('#cusId').val();
        data['code'] = code;
        if(!note){
            alert('Chưa nhập ghi chú!')
        }else{
            data['note'] = note;
            adding(data)
        }
    }
    function addTransactionType(){
        var data = {};
        var note = $('#transactionNote_00').val();
        var code = $('#code00').val();
        if(!note || !code){
            alert('Thiếu thông tin!')
        }else{
            data['customerId'] = $('#cusId00').val();
            data['note'] = note;
            data['code'] = code;
            adding(data)
        }
    }
    function adding(data) {

        $.ajax({
            type: "POST",
            url: '${transactionAPI}',
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
        if (confirm("Đã thêm") == true) {
            window.location.reload(true );
        }

    }

    $('#btnAdd').click(function (e) {
        //sau khi nhan submit no se vao url ma minh muon
        e.preventDefault();
        $('#listForm').submit();
    });

</script>
</body>
</html>

