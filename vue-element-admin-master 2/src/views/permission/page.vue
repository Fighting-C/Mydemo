
<!--============================人员中心/人员管理===============================-->

<template>
  <div class="app-container">
      <div>
        <el-button class="myButton" type="primary" @click.native="handleForm(null,null)">新增</el-button>
      </div>
  <div>roles:{{roles}}</div>
  <div>userId:{{userId}}</div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      botton
     >
      <el-table-column align="center" label="用户ID" width="150">
        <template slot-scope="scope">
          {{ scope.row.userId }}
        </template>
      </el-table-column>
      <el-table-column label="账号" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户角色" align="center" width="400">
        <template slot-scope="scope">
          {{ scope.row.roles }}
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="密码" width="400">
        <template slot-scope="scope">
          <span>{{ scope.row.userPassword }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="创建时间" width="400">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.time) }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作" width="400">
        <template slot-scope="scope">
          <el-button class="myButton" @click.native="handleForm(scope.row.userId, scope.row.name)">编辑</el-button>
          <el-button class="myButton" @click.native="handleDel(scope.row.userId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :page-size="query.limit"
      @current-change="handleCurrentChange"
      layout="prev, pager, next"
      :total="total">
    </el-pagination>
    <!--表单-->
    <el-dialog
      :title="formMap[formName]"
      :visible.sync="formVisible"
      :before-close="hideForm"
      width="85%"
      top="5vh">
      <el-form :model="formData" :rules="formRules" ref="dataForm">
        <el-form-item label="用户名" prop="name">
          <el-input v-model="formData.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="userPassword">
          <el-input type="password" v-model="formData.userPassword" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPassword">
          <el-input type="password" v-model="formData.checkPassword" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="roles">
          <el-radio-group v-model="formData.roles">
            <el-radio :label="0">管理员</el-radio>
            <el-radio :label="1">职工</el-radio>
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
import { getUserList } from  '@/api/table'
import { parseTime } from  '@/utils/index'
import { updateUser } from '@/api/user'
import { deleteUser } from '@/api/user'
import store from '@/store'

const formJson = {
  userId: "",
  userPassword: "",
  name: "",
  checkPassword: "",
  status: 1,
  roles: []
};
export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    const validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.formData.userPassword) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    let validatePass3 = (rule, value, callback) => {
      if (value !== this.formData.userPassword) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      userId: null,
      isShow: true,
      list: null,
      listLoading: false,
      roles:null,
      query: {
        name: "",
        status: "",
        page: 1,
        limit: 20,
        role_id: ""
      },
      total: 0,
      loading: true,
      index: null,
      formName: null,
      formMap: {
        add: "新增",
        edit: "编辑"
      },
      formLoading: false,
      formVisible: false,
      formData: formJson,
      formRules: {},
      addRules: {
        name: [
          { required: true, message: "请输入姓名", trigger: "blur" }
        ],
        userPassword: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { validator: validatePass, trigger: "blur" }
        ],
        checkPassword: [
          {
            required: true,
            message: "请再次输入密码",
            trigger: "blur"
          },
          { validator: validatePass2, trigger: "blur" }
        ],
        // status: [
        //   { required: true, message: "请选择状态", trigger: "change" }
        // ],
        roles: [
          { required: true, message: "请选择角色", trigger: "change" }
        ]
      },
      editRules: {

        name: [
          { required: true, message: "请输入姓名", trigger: "blur" }
        ],
        // status: [
        //   { required: true, message: "请选择状态", trigger: "change" }
        // ],
        userPassword: [
          {  message: "请输入密码", trigger: "blur" },
        ],
        checkPassword: [
          {
            message: "请再次输入密码",
            trigger: "blur"
          },
          { validator: validatePass3, trigger: "blur" }
        ]
      },
      deleteLoading: false
    };

  },
  created(){
    this.roles = store.getters.roles
    this.userId = store.getters.token
    this.fetchData()
  },
  methods: {
    parseTime,
    fetchData(){
      this.listLoading = true
      getUserList().then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    handleForm(index, row){
      this.formVisible = true;
      this.formData.userId = index;
      this.formData.name=row;
      this.formName = 'add';
      this.formRules = this.addRules;
      if (index !== null) {
        this.index = index;
        this.formName = 'edit';
        this.formRules = this.editRules;

      }
    },
    handleCurrentChange(val) {
      this.query.page = val;
      this.fetchData();
    },
    // 刷新表单
    resetForm() {
      if (this.$refs["dataForm"]) {
        // 清空验证信息表单
        this.$refs["dataForm"].clearValidate();
        // 刷新表单
        this.$refs["dataForm"].resetFields();
      }
    },
    // 隐藏表单
    hideForm() {
      // 更改值
      this.formVisible = !this.formVisible;
      // 清空表单
      this.$refs["dataForm"].resetFields();
      return true;
    },
    formSubmit() {
      this.$refs["dataForm"].validate(valid => {
        if (valid) {
          this.formLoading = true;
          let data = Object.assign({}, this.formData);
          updateUser(data).then(response => {
            this.formLoading = false;
            if (response.code !== 20000){
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
    // 删除
    handleDel(id) {
      if (id) {
        this.$confirm("确认删除该记录吗?", "提示", {
          type: "warning"
        })
          .then(() => {
            let params = {id: id };
            this.deleteLoading = true;
            deleteUser(params)
              .then(response => {
                this.deleteLoading = false;
                if (response.code==='20000') {
                  this.$message.error(response.message);
                  return false;
                }
                this.$message.success("操作成功");
                this.fetchData();
              })
              .catch(() => {
                this.deleteLoading = false;
              });
          })
          .catch(() => {
            this.$message.info("取消删除");
          });
      }
    }
  }
}
</script>
