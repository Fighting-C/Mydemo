
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
      title="添加成分股"
    >
<!--      {-->
<!--      "proBetime": 1648869590000,-->
<!--      "proCang": 80,-->
<!--      "proEndtime": 1648955996000,-->
<!--      "proId": 1,-->
<!--      "proLasttime": 1649042400000,-->
<!--      "proManage": 1000,-->
<!--      "proMonGet": 0,-->
<!--      "proName": "产品1",-->
<!--      "proNowGet": 2.3,-->
<!--      "proStatus": "运营中",-->
<!--      "proType": "证券"-->
<!--      }-->
      <el-table-column align="center" label="产品名称" width="95">
        <template slot-scope="scope">
          {{ scope.row.proName }}
        </template>
      </el-table-column>
      <el-table-column label="产品类型" width="200">
        <template slot-scope="scope">
          {{ scope.row.proType }}
        </template>
      </el-table-column>
<!--      <el-table-column label="当前仓位" width="110" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.proCang }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="建议仓位" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.proCang }}
        </template>
      </el-table-column>
      <el-table-column align="center"  label="当前收益率" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.proNowGet }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center"  label="当前收益" width="200">
        <template slot-scope="scope">
          <span>{{handleMoney(scope.row.proNowGet,scope.row.proManage) }}</span>
        </template>
      </el-table-column>
      <el-table-column  align="center" prop="created_at" label="操作" width="200">
          <template slot-scope="scope">
          <el-button  type="primary" class="myButton"  v-if="scope.row.proStatus=='运营中'" @click.native="handleForm(scope.row.proId)">调仓</el-button>
            <span v-if="scope.row.proStatus!='运营中'" >已结算不能操作</span>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      :visible.sync="formVisible"
      :before-close="hideForm"
      width="85%"
      top="5vh">

      <el-table
        v-loading="listLoading2"
        :data="own_share"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
        botton
      >
<!--        {-->
<!--        "indexId": 1,-->
<!--        "proId": 1,-->
<!--        "shareId": 1,-->
<!--        "shareName": "产品1",-->
<!--        "shareNumber": 111,-->
<!--        "sharePrice": 2,-->
<!--        "shareType": "汽车"-->
<!--        }-->
        <el-table-column align="center" prop="share_name" label="股票名字" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.shareName }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="share_type" label="行业" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.shareType }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="share_number" label="股票代码" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.shareNumber }}</span>
        </template>
      </el-table-column>
        <el-table-column align="center" prop="share_price" label="价格" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.sharePrice }}</span>
        </template>
      </el-table-column>
        <el-table-column  align="center" label=修改金额 width="100">
          <template slot-scope="scope">
              <el-input v-model="scope.row.shareManage" @keyup.enter.native="handleMoney(scope.row.indexId,scope.row.shareManage)" ></el-input>
          </template>
        </el-table-column>
        <el-table-column  align="center" label="操作" width="100">
          <template slot-scope="scope">
            <el-button  type="primary" class="myButton"  @click.native="deleteIndex(scope.row.indexId)">删除</el-button>
          </template>
        </el-table-column>
        </el-table>

        <div>
          <el-input v-model="search" style="width: 200px" placeholder="请输入股票名称" @keyup.enter.native="searchIndex(search)">      </el-input>
        </div>


      <el-table
        v-loading="listLoading2"
        :data="shares"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
        botton
      >
        <el-table-column align="center" prop="share_name" label="股票名字" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.shareName }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="share_type" label="行业" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.shareType }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="share_number" label="股票代码" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.shareNumber }}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="share_price" label="价格" width="200">
          <template slot-scope="scope">
            <span>{{ scope.row.sharePrice }}</span>
          </template>
        </el-table-column>
        <el-table-column  align="center" label="操作" width="200">
          <template slot-scope="scope">
          <el-button  type="primary" class="myButton"  @click.native="Add(scope.row.shareId)" >添加</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click.native="hideForm" >完成</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { getProList } from '@/api/table'
import { getShareList } from '@/api/table'
import { getOwnShare } from '@/api/table'
import { Add } from '@/api/table'
import { updateShare } from '@/api/table'
import { deleteshare } from '@/api/table'
import { searchList } from '@/api/table'

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
      search: "",
      own_share:null,
      shares: null,
      formVisible: false,
      list: null,
      formName: null,
      listLoading: false,
      proId: null,
      listLoading2: false
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
    },
    handleForm(proid) {
      this.formVisible = true;
      this.listLoading2 = true
      this.proId = proid
      getShareList().then(response => {
        this.shares = response.data
      })
      getOwnShare({ proid: proid}).then(response => {
        this.own_share = response.data
      })
      this.listLoading2 = false
    },
    hideForm() {
      // 更改值
      this.formVisible = !this.formVisible;
      this.fetchData()
      // 清空表单
      return true;
    },
    Add(share_id) {
      Add({shareid: share_id, proid: this.proId }).then(response => {
        this.listLoading2 = true
        getOwnShare({ proid: this.proId}).then(response => {
          this.own_share = response.data
        })
        this.listLoading2 = false
        this.$message.success('添加成功')
      })

    },
    handleMoney(indexId,money) {
      updateShare({indexId: indexId, money: money }).then(response => {
        this.listLoading2 = true
        getOwnShare({ proid: this.proId}).then(response => {
          this.own_share = response.data
        })
        this.listLoading2 = false
        this.$message.success('修改成功')
      })

    },
    deleteIndex(indexId) {
    deleteshare({proid: this.proId,indexId: indexId}).then(response => {
      this.listLoading2 = true
      getOwnShare({ proid: this.proId}).then(response => {
        this.own_share = response.data
      })
      this.listLoading2 = false
      this.$message.success('删除成功')
    })
  },
    searchIndex(name) {
      if(name === ""){
        this.$message.warning("搜索值不能为空")
      }else {
        name = encodeURIComponent(name)
        searchList({ name: name }).then(response => {
          this.listLoading2 = true
          this.shares = response.data
          this.listLoading2 = false
          this.$message.success('搜索成功')
        })
      }

    },
    handleMoney(index, money) {
      let sum = index * money
      if (sum.toString().length > 7) {
        return sum.toString().substring(0, 7)
      } else {
        return sum
      }
    }
}
}
</script>
