
<!--============================产品中心/调仓工作台===============================-->

<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      botton
    >
      <el-table-column align="center" label="产品名称" width="95">
        <template slot-scope="scope">
          {{ scope.row.proName }}
        </template>
      </el-table-column>
      <el-table-column label="产品类型">
        <template slot-scope="scope">
          {{ scope.row.proType }}
        </template>
      </el-table-column>
      <el-table-column label="当前仓位" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.proType }}</span>
        </template>
      </el-table-column>
      <el-table-column label="建议仓位" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.proType }}
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="月收益率" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.proType }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="三个月收益率" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.proType }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="年收益率" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.proType }}</span>
        </template>
      </el-table-column>
      <el-table-column  align="center" prop="created_at" label="操作" width="200">
        <template>
          <button class="myButton">调仓</button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import { getProList } from '@/api/table'

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
    return {
      list: null,
      listLoading: false
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getProList().then(response => {
        this.list = response.data
        this.listLoading = false
      })
    }
  }
}
</script>
