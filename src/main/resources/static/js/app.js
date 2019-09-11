//全局操作反馈
// $(document).ajaxSuccess(function(evt, request, settings){
//     var text = request.responseText;
//     var s= JSON.parse(text);
//     if (s.code == 400) {
//         toastr.error("错误！")
//     }
//     if (s.code == 200) {
//         toastr.success("成功！")
//     }
// });

var name;

//获取验证码
function verifyCode() {
    $("#imgObj").attr("src","/verifycode?"+new Date().getTime());
}


//登录操作
function login() {
    name = $("input[name='sno']").val();
    $.ajax({
        url: "/user/login",
        type: "post",
        data: $("#login_form").serialize(),
        success: function (data) {
            if (data.msg == "success") {
                window.location.href = "index.html";
                console.log(name);
            } else {
                $("#login_result").empty().append("<label style='color: red'>"+data.msg+"</label>");
            }
        }
    });
}

//Staff 操作
var delStaff = function (sno) {
    var s = function () {
        $.ajax({
            url: "staff/delete",
            type: "post",
            data: {_method: "DELETE", sno: sno},
            success: function () {
                $("#staff_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadStaffPage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/staff/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    sno: $("#staff_search_form #searchSno").val(),
                    sname: $("#staff_search_form #searchSname").val(),
                    ssex: $("#staff_search_form #searchSsex").val(),
                    saddress: $("#staff_search_form #searchSaddress").val(),
                    stel: $("#staff_search_form #searchStel").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'sno',
                title: '员工编号'
            }, {
                field: 'sname',
                title: '员工姓名'
            }, {
                field: 'ssex',
                title: '员工性别'
            }, {
                field: 'saddress',
                title: '出生地址'
            }, {
                field: 'stel',
                title: '联系方式'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delStaff(\'' + row.sno + '\')">删除</button>';
                }
            }]
        };
        $ExTable.initTable("#staff_show", setting);

        //显示添加模态框
        $("#staff_add_btn").click(function () {
            $("#staff_add_form #addSno").val("");
            $("#staff_add_form #addSname").val("");
            $("#staff_add_form #addSsex").val("");
            $("#staff_add_form #addSaddress").val("");
            $("#staff_add_form #addStel").val("");
            $("#staff_add_modal").modal("show");
        });
        //添加
        $("#staff_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "staff/insert",
                type: "post",
                data: $("#staff_add_form").serialize(),
                success: function () {
                    $("#staff_show").bootstrapTable("refresh");
                }
            });
            $("#staff_add_modal").modal("hide");
        });
        //显示修改模态框
        $("#staff_edit_btn").click(function () {
            var id = $("#staff_show").bootstrapTable("getSelections")[0].sno;
            $.ajax({
                url: "/staff/" + id,
                type: "put",
                data: $("#staff_show").serialize(),
                success: function (data) {
                    $("#staff_edit_form #editSsex").empty();
                    if (data.ssex=='男') {
                        $("#staff_edit_form #editSsex").append("<option value='男'>男</option>").append("<option value='女'>女</option>");
                    }else {
                        $("#staff_edit_form #editSsex").append("<option value='女'>女</option>").append("<option value='男'>男</option>");
                    }
                    $("#staff_edit_form #editSno").val(data.sno);
                    $("#staff_edit_form #editSname").val(data.sname);
                    $("#staff_edit_form #editSaddress").val(data.saddress);
                    $("#staff_edit_form #editStel").val(data.stel);
                }
            });
            $("#staff_edit_modal").modal("show");
        });
        //修改
        $("#staff_edit").click(function () {
            $.ajax({
                url: "staff/update",
                type: "post",
                data: $("#staff_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#staff_show").bootstrapTable("refresh");
                }
            });
            $("#staff_edit_modal").modal("hide");
        });

        //删除操作
        $("#staff_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "staff/delete",
                    type: "post",
                    data: {_method: "DELETE", sno: $("#staff_show").bootstrapTable("getSelections")[0].sno},
                    success: function () {
                        $("#staff_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        //显示查找模态框
        $("#staff_search_btn").click(function () {
            $("#staff_search_form #searchSno").val("");
            $("#staff_search_form #searchSname").val("");
            $("#staff_search_form #searchSsex").append("<option value='男'>男</option>");
            $("#staff_search_form #searchSsex").append("<option value='女'>女</option>");
            $("#staff_search_form #searchSaddress").val("");
            $("#staff_search_form #searchStel").val("");
            $("#staff_search_modal").modal("show");
        });
        //查询操作
        $("#staff_search").click(function () {
            $("#staff_show").bootstrapTable("destroy");
            $ExTable.initTable("#staff_show", setting);
            $("#staff_search_modal").modal("hide");
            $("#staff_search_form #searchSsex").empty();
        });
    });
}

//Cargo 操作
var delCargo = function (cno) {
    var s = function () {
        $.ajax({
            url: "cargo/delete",
            type: "post",
            data: {_method: "DELETE", cno: cno},
            success: function () {
                $("#cargo_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadCargoPage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/cargo/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    cno: $("#cargo_search_form #searchCno").val(),
                    cname: $("#cargo_search_form #searchCname").val(),
                    lowestprice: $("#cargo_search_form #lowestPrice").val(),
                    hightestprice: $("#cargo_search_form #hightestPrice").val(),
                    pno: $("#cargo_search_form #searchPno").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'cno',
                title: '货物编号'
            }, {
                field: 'cname',
                title: '货物名称'
            }, {
                field: 'cprice',
                title: '单价'
            }, {
                field: 'pno',
                title: '供应商编号'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm cargo_del" onclick="delCargo(\'' + row.cno + '\')">删除</button>';
                }
            }
            ]
        };
        $ExTable.initTable("#cargo_show", setting);

        //显示添加模态框
        $("#cargo_add_btn").click(function () {
            initSelect("provider/pno", "#cargo_add_form #addPno");
            $("#cargo_add_form #addCno").val("");
            $("#cargo_add_form #addCname").val("");
            $("#cargo_add_form #addCprice").val("");
            $("#cargo_add_modal").modal("show");
        });
        //添加
        $("#cargo_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "cargo/insert",
                type: "post",
                data: $("#cargo_add_form").serialize(),
                success: function () {
                    $("#cargo_show").bootstrapTable("refresh");
                }
            });
            $("#cargo_add_modal").modal("hide");
        });

        //显示修改模态框
        $("#cargo_edit_btn").click(function () {
            var id = $("#cargo_show").bootstrapTable("getSelections")[0].cno;
            $.ajax({
                url: "/cargo/" + id,
                type: "put",
                data: $("#cargo_show").serialize(),
                success: function (data) {
                    initEditSelect("provider/pno", "#cargo_edit_form #editPno", data.pno);
                    $("#cargo_edit_form #editCno").val(data.cno);
                    $("#cargo_edit_form #editCname").val(data.cname);
                    $("#cargo_edit_form #editCprice").val(data.cprice);
                }
            });
            $("#cargo_edit_modal").modal("show");
        });
        //修改
        $("#cargo_edit").click(function () {
            $.ajax({
                url: "cargo/update",
                type: "post",
                data: $("#cargo_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#cargo_show").bootstrapTable("refresh");
                }
            });
            $("#cargo_edit_modal").modal("hide");
        });
        //删除
        $("#cargo_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "cargo/delete",
                    type: "post",
                    data: {_method: "DELETE", cno: $("#cargo_show").bootstrapTable("getSelections")[0].cno},
                    success: function () {
                        $("#cargo_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        initSelect("provider/pno", "#cargo_search_form #searchPno");
        //显示查找模态框
        $("#cargo_search_btn").click(function () {
            $("#cargo_search_form #searchCno").val("");
            $("#cargo_search_form #searchCname").val("");
            $("#cargo_search_form #searchCprice").val("");
            $("#cargo_search_modal").modal("show");
        });
        //查询操作
        $("#cargo_search").click(function () {
            $("#cargo_show").bootstrapTable("destroy");
            $ExTable.initTable("#cargo_show", setting);
            $("#cargo_search_modal").modal("hide");
        });
        //导出Excel
        $("#cargo_export_btn").click(function () {
            window.open("/cargo/export?"+$("#cargo_search_form").serialize(),"_blank");
        });
    });
}

//Provider操作
var delProvider = function (pno) {
    var s = function () {
        $.ajax({
            url: "provider/delete",
            type: "post",
            data: {_method: "DELETE", pno: pno},
            success: function () {
                $("#cargo_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadProviderPage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/provider/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    pno: $("#provider_search_form #searchPno").val(),
                    pname: $("#provider_search_form #searchPname").val(),
                    paddress: $("#provider_search_form #searchPaddress").val(),
                    ptel: $("#provider_search_form #searchPtel").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'pno',
                title: '供应商代码'
            }, {
                field: 'pname',
                title: '供应商名称'
            }, {
                field: 'paddress',
                title: '地址'
            }, {
                field: 'ptel',
                title: '联系方式'
            }, {
                field: 'pcomment',
                title: '详情备注'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delProvider(\'' + row.pno + '\')">删除</button>';
                }
            }
            ]
        };
        $ExTable.initTable("#provider_show", setting);

        //显示添加模态框
        $("#provider_add_btn").click(function () {
            $("#provider_add_form #addPno").val("");
            $("#provider_add_form #addPname").val("");
            $("#provider_add_form #addPaddress").val("");
            $("#provider_add_form #addPtel").val("");
            $("#provider_add_form #addPcomment").val("");
            $("#provider_add_modal").modal("show");
        });
        //添加
        $("#provider_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "provider/insert",
                type: "post",
                data: $("#provider_add_form").serialize(),
                success: function () {
                    $("#provider_show").bootstrapTable("refresh");
                }
            });
            $("#provider_add_modal").modal("hide");
        });
        //显示修改模态框
        $("#provider_edit_btn").click(function () {
            var id = $("#provider_show").bootstrapTable("getSelections")[0].pno;
            $.ajax({
                url: "/provider/" + id,
                type: "put",
                data: $("#provider_show").serialize(),
                success: function (data) {
                    $("#provider_edit_form #editPno").val(data.pno);
                    $("#provider_edit_form #editPname").val(data.pname);
                    $("#provider_edit_form #editPaddress").val(data.paddress);
                    $("#provider_edit_form #editPtel").val(data.ptel);
                    $("#provider_edit_form #editPcomment").val(data.pcomment);
                }
            });
            $("#provider_edit_modal").modal("show");
        });
        //修改
        $("#provider_edit").click(function () {
            $.ajax({
                url: "provider/update",
                type: "post",
                data: $("#provider_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#provider_show").bootstrapTable("refresh");
                }
            });
            $("#provider_edit_modal").modal("hide");
        });
        //删除
        $("#provider_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "provider/delete",
                    type: "post",
                    data: {_method: "DELETE", pno: $("#provider_show").bootstrapTable("getSelections")[0].pno},
                    success: function () {
                        $("#provider_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        //显示查找模态框
        $("#provider_search_btn").click(function () {
            $("#provider_search_form #searchPno").val("");
            $("#provider_search_form #searchPname").val("");
            $("#provider_search_form #searchPaddress").val("");
            $("#provider_search_form #searchPtel").val("");
            $("#provider_search_modal").modal("show");
        });
        //查询操作
        $("#provider_search").click(function () {
            $("#provider_show").bootstrapTable("destroy");
            $ExTable.initTable("#provider_show", setting);
            $("#provider_search_modal").modal("hide");
        });
        //导出Excel
        $("#provider_export_btn").click(function () {
            window.open("/provider/export?"+$("#provider_search_form").serialize(),"_blank");
        });
    });
}

//Warehouse操作
var delWarehouse = function (wno) {
    var s = function () {
        $.ajax({
            url: "warehouse/delete",
            type: "post",
            data: {_method: "DELETE", wno: wno},
            success: function () {
                $("#warehouse_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadWarehousePage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/warehouse/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    wno: $("#warehouse_search_form #searchWno").val(),
                    wname: $("#warehouse_search_form #searchWname").val(),
                    waddress: $("#warehouse_search_form #searchWaddress").val(),
                    sno: $("#warehouse_search_form #searchSno").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'wno',
                title: '仓库编号'
            }, {
                field: 'wname',
                title: '仓库名称'
            }, {
                field: 'waddress',
                title: '地址'
            }, {
                field: 'sno',
                title: '管理员编号'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delWarehouse(\'' + row.wno + '\')">删除</button>';
                }
            }
            ]
        };
        $ExTable.initTable("#warehouse_show", setting);
        //显示添加模态框
        $("#warehouse_add_btn").click(function () {
            initSelect("staff/sno", "#warehouse_add_form #addSno");
            $("#warehouse_add_form #addWno").val("");
            $("#warehouse_add_form #addWname").val("");
            $("#warehouse_add_form #addWaddress").val("");
            $("#warehouse_add_modal").modal("show");
        });
        //添加
        $("#warehouse_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "warehouse/insert",
                type: "post",
                data: $("#warehouse_add_form").serialize(),
                success: function () {
                    $("#warehouse_show").bootstrapTable("refresh");
                }
            });
            $("#warehouse_add_modal").modal("hide");
        });
        //显示修改模态框
        $("#warehouse_edit_btn").click(function () {
            var id = $("#warehouse_show").bootstrapTable("getSelections")[0].wno;
            $.ajax({
                url: "/warehouse/" + id,
                type: "get",
                //data: $("#warehouse_show").serialize(),
                success: function (data) {
                    initEditSelect("/staff/sno", "#warehouse_edit_form #editSno", data.sno);
                    $("#warehouse_edit_form #editWno").val(data.wno);
                    $("#warehouse_edit_form #editWname").val(data.wname);
                    $("#warehouse_edit_form #editWaddress").val(data.waddress);
                }
            });
            $("#warehouse_edit_modal").modal("show");
        });
        //修改
        $("#warehouse_edit").click(function () {
            $.ajax({
                url: "warehouse/update",
                type: "post",
                data: $("#warehouse_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#warehouse_show").bootstrapTable("refresh");
                }
            });
            $("#warehouse_edit_modal").modal("hide");
        });
        //删除
        $("#warehouse_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "warehouse/delete",
                    type: "post",
                    data: {_method: "DELETE", wno: $("#provider_show").bootstrapTable("getSelections")[0].wno},
                    success: function () {
                        $("#warehouse_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        initSelect("staff/sno", "#warehouse_search_form #searchSno");
        //显示查找模态框
        $("#warehouse_search_btn").click(function () {
            $("#warehouse_search_form #searchWno").val("");
            $("#warehouse_search_form #searchWname").val("");
            $("#warehouse_search_form #searchWaddress").val("");
            $("#warehouse_search_modal").modal("show");
        });
        //查询操作
        $("#warehouse_search").click(function () {
            $("#warehouse_show").bootstrapTable("destroy");
            $ExTable.initTable("#warehouse_show", setting);
            $("#warehouse_search_modal").modal("hide");
        });
        //导出Excel
        // $("#warehouse_export_btn").click(function () {
        //     window.open("/warehouse/export?"+$("#warehouse_search_form").serialize(),"_blank");
        // });
    });
}

//进库购买操作perchance
var delPerchance = function (pid) {
    var s = function () {
        $.ajax({
            url: "perchance/delete",
            type: "post",
            data: {_method: "DELETE", pid: pid},
            success: function () {
                $("#perchance_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadPerchancePage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/perchance/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    cno: $("#perchance_search_form #searchCno").val(),
                    wno: $("#perchance_search_form #searchWno").val(),
                    sno: $("#perchance_search_form #searchSno").val(),
                    lowestprice: $("#perchance_search_form #lowestPrice").val(),
                    hightestprice: $("#perchance_search_form #hightestPrice").val(),
                    startdate: $("#perchance_search_form #startDate").val(),
                    enddate: $("#perchance_search_form #endDate").val(),
                    pnum: $("#perchance_search_form #searchPnum").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'cno',
                title: '货物编号'
            }, {
                field: 'pprice',
                title: '进货时价格'
            }, {
                field: 'wno',
                title: '仓库编号'
            }, {
                field: 'sno',
                title: '进货员编号'
            }, {
                field: 'pdate',
                title: '日期',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }, {
                field: 'pnum',
                title: '数量'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delPerchance(\'' + row.pid + '\')">删除</button>';
                }
            }]
        };
        $ExTable.initTable("#perchance_show", setting);

        //显示增加模态框前清空数据
        $("#perchance_add_btn").click(function () {
            $("#perchance_add_form #addCno").val("");
            $("#perchance_add_form #addPprice").val("");
            $("#perchance_add_form #addWno").val("");
            $("#perchance_add_form #addSno").val("");
            $("#perchance_add_form #addPnum").val("");
            $("#perchance_add_modal").modal("show");
        });

        //添加
        $("#perchance_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "perchance/insert",
                type: "post",
                data: $("#perchance_add_form").serialize()+'&pid='+guid(),
                success: function () {
                    $("#perchance_show").bootstrapTable("refresh");
                }
            });
            $("#perchance_add_modal").modal("hide");
        });

        //显示修改模态框
        $("#perchance_edit_btn").click(function () {
            var id = $("#perchance_show").bootstrapTable("getSelections")[0].pid;
            $.ajax({
                url: "/perchance/" + id,
                type: "get",
                //data: $("#perchance_show").serialize(),
                success: function (data) {
                    $("#perchance_edit_form #editCno").val(data.cno);
                    $("#perchance_edit_form #editPprice").val(data.pprice);
                    $("#perchance_edit_form #editWno").val(data.wno);
                    $("#perchance_edit_form #editSno").val(data.sno);
                    $("#perchance_edit_form #editPnum").val(data.pnum);
                }
            });
            $("#perchance_edit_modal").modal("show");
        });
        //修改
        $("#perchance_edit").click(function () {
            $.ajax({
                url: "perchance/update",
                type: "post",
                data: $("#perchance_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#perchance_show").bootstrapTable("refresh");
                }
            });
            $("#perchance_edit_modal").modal("hide");
        });
        //删除
        $("#perchance_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "perchance/delete",
                    type: "post",
                    data: {_method: "DELETE", pid: $("#perchance_show").bootstrapTable("getSelections")[0].pid},
                    success: function () {
                        $("#perchance_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        //initSelect("staff/sno", "#perchance_search_form #searchSno");
        //显示查找模态框
        $("#perchance_search_btn").click(function () {
            $("#perchance_search_form #searchCno").val("");
            $("#perchance_search_form #searchWno").val("");
            $("#perchance_search_form #searchSno").val("");
            $("#perchance_search_form #lowestPrice").val("");
            $("#perchance_search_form #hightestPrice").val("");
            $("#perchance_search_form #searchPnum").val("");
            $("#perchance_search_modal").modal("show");
        });
        //查询操作
        $("#perchance_search").click(function () {
            $("#perchance_show").bootstrapTable("destroy");
            $ExTable.initTable("#perchance_show", setting);
            $("#perchance_search_modal").modal("hide");
        });

        //选择日期
        $(".form_datetime").datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            language: 'zh-CN',
            autoclose: 1,
            startDate: '2019-01-01'
        });
        $(".selectpicker").selectpicker({});

        //导出Excel
        // $("#warehouse_export_btn").click(function () {
        //     window.open("/warehouse/export?"+$("#warehouse_search_form").serialize(),"_blank");
        // });
    });

}

//进库购买操作sell
var delSell = function (sid) {
    var s = function () {
        $.ajax({
            url: "sell/delete",
            type: "post",
            data: {_method: "DELETE", sid: sid},
            success: function () {
                $("#sell_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadSellPage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/sell/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    cno: $("#sell_search_form #searchCno").val(),
                    wno: $("#sell_search_form #searchWno").val(),
                    sno: $("#sell_search_form #searchSno").val(),
                    lowestprice: $("#sell_search_form #lowestPrice").val(),
                    hightestprice: $("#sell_search_form #hightestPrice").val(),
                    startdate: $("#sell_search_form #startDate").val(),
                    enddate: $("#sell_search_form #endDate").val(),
                    snum: $("#sell_search_form #searchSnum").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'cno',
                title: '货物编号'
            }, {
                field: 'sprice',
                title: '进货时价格'
            }, {
                field: 'wno',
                title: '仓库编号'
            }, {
                field: 'sno',
                title: '进货员编号'
            }, {
                field: 'sdate',
                title: '日期',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }, {
                field: 'snum',
                title: '数量'
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delSell(\'' + row.sid + '\')">删除</button>';
                }
            }]
        };
        $ExTable.initTable("#sell_show", setting);

        //显示增加模态框前清空数据
        $("#sell_add_btn").click(function () {
            $("#sell_add_form #addCno").val("");
            $("#sell_add_form #addSprice").val("");
            $("#sell_add_form #addWno").val("");
            $("#sell_add_form #addSno").val("");
            $("#sell_add_form #addSnum").val("");
            $("#sell_add_modal").modal("show");
        });

        //添加
        $("#sell_add").click(function () {
            //添加操作，成功则刷新
            $.ajax({
                url: "sell/insert",
                type: "post",
                data: $("#sell_add_form").serialize()+'&sid='+guid(),
                success: function () {
                    $("#sell_show").bootstrapTable("refresh");
                }
            });
            $("#sell_add_modal").modal("hide");
        });

        //显示修改模态框
        $("#sell_edit_btn").click(function () {
            var id = $("#sell_show").bootstrapTable("getSelections")[0].sid;
            $.ajax({
                url: "/sell/" + id,
                type: "get",
                //data: $("#sell_show").serialize(),
                success: function (data) {
                    $("#sell_edit_form #editCno").val(data.cno);
                    $("#sell_edit_form #editSprice").val(data.sprice);
                    $("#sell_edit_form #editWno").val(data.wno);
                    $("#sell_edit_form #editSno").val(data.sno);
                    $("#sell_edit_form #editSnum").val(data.snum);
                }
            });
            $("#sell_edit_modal").modal("show");
        });
        //修改
        $("#sell_edit").click(function () {
            $.ajax({
                url: "sell/update",
                type: "post",
                data: $("#sell_edit_form").serialize() + "&_method=PUT",
                success: function () {
                    $("#sell_show").bootstrapTable("refresh");
                }
            });
            $("#sell_edit_modal").modal("hide");
        });
        //删除
        $("#sell_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "sell/delete",
                    type: "post",
                    data: {_method: "DELETE", pid: $("#sell_show").bootstrapTable("getSelections")[0].sid},
                    success: function () {
                        $("#sell_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        //initSelect("staff/sno", "#sell_search_form #searchSno");
        //显示查找模态框
        $("#sell_search_btn").click(function () {
            $("#sell_search_form #searchCno").val("");
            $("#sell_search_form #searchWno").val("");
            $("#sell_search_form #searchSno").val("");
            $("#sell_search_form #lowestPrice").val("");
            $("#sell_search_form #hightestPrice").val("");
            $("#sell_search_form #searchSnum").val("");
            $("#sell_search_modal").modal("show");
        });
        //查询操作
        $("#sell_search").click(function () {
            $("#sell_show").bootstrapTable("destroy");
            $ExTable.initTable("#sell_show", setting);
            $("#sell_search_modal").modal("hide");
        });

        //选择日期
        $(".form_datetime").datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            language: 'zh-CN',
            autoclose: 1,
            startDate: '2019-01-01'
        });
        $(".selectpicker").selectpicker({});

        //导出Excel
        // $("#warehouse_export_btn").click(function () {
        //     window.open("/warehouse/export?"+$("#warehouse_search_form").serialize(),"_blank");
        // });
    });

}

//库存操作store
var delStore = function (stno) {
    var s = function () {
        $.ajax({
            url: "store/delete",
            type: "post",
            data: {_method: "DELETE", stno: stno},
            success: function () {
                $("#store_show").bootstrapTable("refresh");
            }
        });
    };
    tip.confirm(s);
};

function loadStorePage(ele) {
    var url = $(ele).attr("url");
    $("#main").load(url, function () {
        var setting = {
            url: '/store/search',
            singleSelect: true,
            responseHandler: function (res) {
                //在ajax获取到数据，渲染表格之前，修改数据源
                var nres = [];
                nres.push({total: res.total, rows: res.list});
                return nres[0];
            },
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    search: params.search,
                    cno: $("#store_search_form #searchCno").val(),
                    wno: $("#store_search_form #searchWno").val(),
                    lowestnum: $("#store_search_form #lowestNum").val(),
                    hightestnum: $("#store_search_form #hightestNum").val(),
                    startdate: $("#store_search_form #startDate").val(),
                    enddate: $("#store_search_form #endDate").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'cno',
                title: '货物编号'
            }, {
                field: 'wno',
                title: '仓库编号'
            }, {
                field: 'stnum',
                title: '数量'
            }, {
                field: 'sdate',
                title: '日期',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }, {
                field: 'ID',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="delStore(\'' + row.stno + '\')">删除</button>';
                }
            }]
        };
        $ExTable.initTable("#store_show", setting);

        //删除
        $("#store_delete_btn").click(function () {
            var s = function () {
                $.ajax({
                    url: "store/delete",
                    type: "post",
                    data: {_method: "DELETE", stno: $("#store_show").bootstrapTable("getSelections")[0].stno},
                    success: function () {
                        $("#store_show").bootstrapTable("refresh");
                    }
                });
            };
            tip.confirm(s);
        });
        //initSelect("staff/sno", "#store_search_form #searchSno");
        //显示查找模态框
        $("#store_search_btn").click(function () {
            $("#store_search_form #searchCno").val("");
            $("#store_search_form #searchWno").val("");
            $("#store_search_form #lowestNum").val("");
            $("#store_search_form #hightestNum").val("");
            $("#store_search_form #startDate").val("");
            $("#store_search_form #endDate").val("");
            $("#store_search_modal").modal("show");
        });
        //查询操作
        $("#store_search").click(function () {
            $("#store_show").bootstrapTable("destroy");
            $ExTable.initTable("#store_show", setting);
            $("#store_search_modal").modal("hide");
        });

        //选择日期
        $(".form_datetime").datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            language: 'zh-CN',
            autoclose: 1,
            startDate: '2019-01-01'
        });
        $(".selectpicker").selectpicker({});

        //导出Excel
        // $("#warehouse_export_btn").click(function () {
        //     window.open("/warehouse/export?"+$("#warehouse_search_form").serialize(),"_blank");
        // });
    });

}

var tip = {};

//转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(date) {
        var dateee = new Date(date).toJSON();
        return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
}

//guid生成
function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}

tip.confirm = function (ops) {
    bootbox.confirm({
        message: "确认删除？",
        size: 'small',
        buttons: {
            confirm: {label: '<i class="glyphicon glyphicon-ok"></i> 是', className: 'btn-danger'},
            cancel: {
                label: '<i class="glyphicon glyphicon-remove"></i> 否',
                className: 'btn-success'
            }
        },
        callback: function (result) {
            if (result) {
                ops();
            }
        }
    })

};

//初始化搜索、添加下拉框封装函数
function initSelect(url, form_select) {
    $(form_select).empty();
    $.ajax({
        url: url,
        type: "post",
        success: function (data) {
            $(form_select).append("<option value=''>请选择</option>");
            for (var i = 0; i < data.length; i++) {
                $(form_select).append("<option value=" + data[i] + ">" + data[i] + "</option>");
            }
        }
    });
}

//初始化修改下拉框封装函数
function initEditSelect(url, form_select, d) {
    $(form_select).empty();
    $.ajax({
        url: url,
        type: "post",
        success: function (data) {
            $(form_select).append("<option value='" + d + "'>" + d + "</option>");
            for (var i = 0; i < data.length; i++) {
                if (d == data[i]) {
                    continue;
                }
                $(form_select).append("<option value=" + data[i] + ">" + data[i] + "</option>");
            }
        }
    });
}

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}

$(function () {
    var user = getCookie("user");
    $("#user").text(user);
});

var $ExTable = (function () {
    var bootstrapTable_default = {
        method: 'get',
        striped: false,
        cache: false,
        pagination: true,
        toolbar: '#toolbar',
        sortable: false,
        sidePagination: "server",
        pageNumber: 1,
        pageSize: 5,
        pageList: [5, 10, 25, 50, 100],
        search: true,
        strictSearch: false,
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        idField: "id",
        uniqueId: "id",
        cardView: false,
        detailView: false,
        smartDisplay: false
    };

    function _initTable(id, settings) {
        var params = $.extend({}, bootstrapTable_default, settings);
        if (typeof params.url == 'undefined') {
            throw '初始化表格失败，请配置url参数！';
        }
        if (typeof params.columns == 'undefined') {
            throw '初始化表格失败，请配置columns参数！';
        }
        $(id).bootstrapTable(params);
    }

    return {
        initTable: function (id, settings) {
            _initTable(id, settings);
        },
        refreshTable: function (id) {
            $(id).bootstrapTable('refresh');
        },
        refresh: function (id, set) {
            $(id).bootstrapTable('refresh', set);
        }
    }
})($);





