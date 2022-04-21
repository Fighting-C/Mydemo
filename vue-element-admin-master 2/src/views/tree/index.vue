
<!--============================产品中心/管理产品===============================-->

<template>
  <div class="app-container">

    <div>
      <el-button class="myButton" type="primary" @click.native="handleForm(null)">管理产品</el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      botton
    >
      <el-table-column align="center" label="产品名称" width="110">
        <template slot-scope="scope">
          {{ scope.row.proName }}
        </template>
      </el-table-column>
      <el-table-column label="产品类型" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.proType }}
        </template>
      </el-table-column>
      <el-table-column label="当前管理资产" width="200" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.proManage }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="募集开始时间" width="300">
        <template slot-scope="scope">
          <span> {{ parseTime(scope.row.proBetime)}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="募集结束时间" width="300">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.proEndtime) }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="上次分红时间" width="300">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.proLasttime)}}</span>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="150" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.proStatus | statusFilter">{{ scope.row.proStatus }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作" width="200" v-if="this.userroles === 'admin'||this.userroles=== 'editor'">
        <template slot-scope="scope">
          <el-button  type="primary" class="myButton"  @click.native="fenHong(scope.row.proId)" v-show="scope.row.proStatus!=='已结算'">分红</el-button>
          <el-button type="primary" class="myButton" @click.native="jieSuan(scope.row.proId)" v-show="scope.row.proStatus!=='已结算'">结算</el-button>
          <spen v-show="scope.row.proStatus==='已结算'">已结算</spen>
        </template>
      </el-table-column>
    </el-table>
    <!--表单-->
    <el-dialog
      :title="formMap[formName]"
      :visible.sync="formVisible"
      :before-close="hideForm"
      width="85%"
      top="5vh">
      <el-form :model="formData" :rules="formRules"  ref="dataForm" >
        <el-form-item label="产品名称" prop="proname">
          <el-input v-model="formData.proname" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="产品类型" prop="protype" >
          <el-radio-group v-model="formData.protype">
            <el-radio :label="0">公募</el-radio>
            <el-radio :label="1">私募</el-radio>
            <el-radio :label="2">集合理财</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="募集开始时间" prop="probegintime">
          <el-date-picker type="date" v-model="formData.probegintime" placeholder="选择日期" value-format="yyyy-mm-dd" ></el-date-picker>
        </el-form-item>
        <el-form-item label="募集结束时间" prop="proendtime">
          <el-date-picker type="date" v-model="formData.proendtime" placeholder="选择日期" value-format="yyyy-mm-dd" ></el-date-picker>
        </el-form-item>
        <el-form-item label="最低募集金额" prop="lowmoney">
          <el-input v-model="formData.lowmoney" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="建议仓位" prop="advice" >
          <el-input v-model="formData.advice" auto-complete="off" aria-valuemax="100"></el-input>
        </el-form-item>

        <el-form-item label="分红方式" prop="ways">
          <el-radio-group v-model="formData.ways">
            <el-radio :label="0">现金</el-radio>
            <el-radio :label="1">其他</el-radio>
          </el-radio-group>
        </el-form-item>
        <!--        <el-form-item label="状态" prop="status">-->
        <!--          <el-radio-group v-model="formData.status">-->
        <!--            <el-radio :label="0">禁用</el-radio>-->
        <!--            <el-radio :label="1">正常</el-radio>-->
        <!--            <el-radio :label="2">未验证</el-radio>-->
        <!--          </el-radio-group>-->
        <!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="hideForm">取消</el-button>
        <el-button type="primary" @click.native="formSubmit()" :loading="formLoading">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getProList } from '@/api/table'
import { parseTime } from '@/utils/index'
import { updatePro } from '@/api/pro'
import { fenHong } from '@/api/pro'
import { jieSuan } from '@/api/pro'
import store from '@/store'
const formJson = {
  protype:"",
  proname:"",
  probegintime: "",
  proendtime: "",
  lowmoney:"",
  advice: 80,
  ways: "",
};
export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        '运营中': 'success',
        '审核中': 'gray',
        '已结算': 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      isShow: true,
      list: null,
      listLoading: false,
      roles: null,
      userroles:null,
      formLoading: false,
      formVisible: false,
      formName: null,
      formData: formJson,
      formMap: {
        add: "新增",
        edit: "编辑"
      },
      formRules: {},
      addRules: {
        proname: [
          { required: true, message: "请输入产品名称", trigger: "blur" }
        ],
        protype: [
          { required: true, message: "请选择产品类型", trigger: "blur" }
        ],
        probegintime: [
          { required: true, message: "请输入产品募集开始时间", trigger: "blur" }
        ],
        proendtime: [
          { required: true, message: "请输入产品募集结束时间", trigger: "blur" }
        ],
        lowmoney: [
          { required: true, message: "请输入产品最低募集金额", trigger: "blur" }
        ],
        advice: [
          { required: true, message: "请输入产品建议仓位", trigger: "blur" }
        ],
        ways: [
          { required: true, message: "请输入产品分红方式", trigger: "blur" }
        ]
      },

    }
  },
  created() {
    this.fetchData()
    this.userroles = store.getters.roles
  },
  methods: {
    parseTime,
    fetchData() {
      this.listLoading = true
      getProList().then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    handleForm(proid) {
      this.formVisible = true;
      if (proid != null) {
        this.formName='修改产品'
      }else {
        this.formName='新建产品'
      }
      this.formRules = this.addRules;
    },

    hideForm() {
      // 更改值
      this.formVisible = !this.formVisible;
      this.formData.proname = "";
      // 清空表单
      this.$refs["dataForm"].resetFields();
      return true;
    },
    resetForm() {
      if (this.$refs["dataForm"]) {
        // 清空验证信息表单
        this.$refs["dataForm"].clearValidate();
        // 刷新表单
        this.$refs["dataForm"].resetFields();
      }
    },
    formSubmit() {
      this.$refs["dataForm"].validate(valid => {
        if (valid) {
          this.formLoading = true;
          this.formData.proname = encodeURIComponent( this.formData.proname)
          let data = Object.assign({}, this.formData);
          updatePro(data).then(response => {
            this.formLoading = false;
            if (response.code !== 20000) {
              // this.$message.error(response.message);
              this.$message.error('操作失败');
              this.fetchData();
              this.resetForm();
              return false;
            }
            this.$message.success("操作成功");
            this.formVisible = false;
            this.fetchData();
            刷新表单
            this.resetForm();
          });
        }
      });
    },
    fenHong(proId) {
        fenHong(
          {proId : proId ,
            userId : store.getters.token
          }
        ).then(response => {

          if (response.code !== 20000) {
            // this.$message.error(response.message);
            this.$message.error('操作失败');
            this.fetchData();
            return false;
          }
          this.$message.success("操作成功");
          this.fetchData();
        });
    },
    jieSuan(proId) {
        jieSuan(
          {proId : proId ,
            userId : store.getters.token
          }
        ).then(response => {

          if (response.code !== 20000) {
            // this.$message.error(response.message);
            this.$message.error('操作失败');
            this.fetchData();
            return false;
          }
          this.$message.success("操作成功");
          this.fetchData();
        });
    }
  }
}
</script>
