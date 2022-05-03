
<!--============================审批中心===============================-->

<template>
  <div class="app-container">

    <header>
      <div class="Header">我的申请</div>
    </header>
    <el-table
      v-loading="listLoading"
      :data="fromTask"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      botton
    >
      <el-table-column align="center" label="审批单ID" width="120">
        <template slot-scope="scope">
          {{ scope.row.taskId}}
        </template>
      </el-table-column>
      <el-table-column label="产品ID"  align="center" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.proId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作类型" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.taskType }}
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作人ID" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.fromUserid }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="申请时间" width="240">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.taskTime)  }}</span>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="200" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.taskStatu | statusFilter">{{ scope.row.taskStatu }}</el-tag>
        </template>
      </el-table-column>
    </el-table>
    <header>
      <div class="Header">待我处理</div>
    </header>

    <el-table
      v-loading="listLoading"
      :data="toTask"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      botton
    >
      <el-table-column align="center" label="审批单ID" width="120">
        <template slot-scope="scope">
          {{ scope.row.taskId }}
        </template>
      </el-table-column>
      <el-table-column label="产品ID" width="200" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.proId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作类型" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.taskType }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作人ID" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.fromUserid }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center"  label="申请时间" width="240">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.taskTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column  align="center" prop="created_at" label="操作" width="200">
        <template slot-scope="scope">
          <el-button  type="primary" class="myButton"  @click.native="unpass(scope.row.taskId)">拒绝</el-button>
          <el-button type="primary" class="myButton"  @click.native="pass(scope.row.taskId)">通过</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import { getFromTask } from '@/api/task'
  import { getToTask } from '@/api/task'
  import store from '@/store'
  import { pass } from  '@/api/task'
  import { unpass } from  '@/api/task'
  import { parseTime } from  '@/utils/index'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        '已通过': 'success',
        '正在处理': 'gray',
        '未通过': 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      userroles: null,
      userId : null,
      fromTask: null,
      toTask: null,
      listLoading: false
    }
  },
  created() {
    this.userId = store.getters.token
    this.userroles = store.getters.roles
    this.fetchData()

  },
  methods: {
    parseTime,
    fetchData() {
      this.listLoading = true
      let params ={id : this.userId}
      let params2 ={id : this.userroles}
      getFromTask(params).then(response => {
        this.fromTask = response.data
      })
      getToTask(params2).then(response => {
        this.toTask = response.data
        this.listLoading = false
      })

    },
    pass(taskId) {
      pass({taskId:taskId }).then(response => {

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
    unpass(taskId) {
      unpass({taskId:taskId }).then(response => {

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
<style>
  .title{
    color: transparent;
     -webkit-text-stroke: 1px black;
     letter-spacing: 0.04em;
    align-items: center;
  }
</style>
