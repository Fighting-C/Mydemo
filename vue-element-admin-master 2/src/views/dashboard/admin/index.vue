<template>
  <div class="app-container">
<!--    {-->
<!--    "manageMoney": 7000,-->
<!--    "downPro": 0,-->
<!--    "otherMoney": 993000,-->
<!--    "upPro": 0,-->
<!--    "nowMoney": 0,-->
<!--    "proNumber": 4-->
<!--    }-->
    <div class="root"  v-loading="listLoading">
      <div class="header">数据总览</div>
      <div class="container">
        <div class="row">
          <div class="label">总管理资产</div>
          <div class="value" >{{this.map.manageMoney}}元</div>
        </div>
        <div class="row">
          <div class="label">金融产品数</div>
          <div class="value">{{this.map.proNumber}}个</div>
        </div>
        <div class="row">
          <div class="label">当前基金市值</div>
          <div class="value">{{this.map.nowMoney}}元</div>
        </div>
        <div class="row">
          <div class="label">正收益产品数</div>
          <div class="value">{{this.map.upPro}}个</div>
        </div>
        <div class="row">
          <div class="label">空闲资产</div>
          <div class="value">{{this.map.otherMoney}}元</div>
        </div>
        <div class="row">
          <div class="label">负收益产品数</div>
          <div class="value">{{this.map.downPro}}个</div>
        </div>
      </div>
    </div>

   </div>

</template>

<script>
  import { gettable } from '@/api/table'

export default {
  name: 'DashboardAdmin',

  data() {
    return {
      map:null,
      listLoading:false,
    }
  },
  created() {
    this.fetchData()

  },
  methods: {
    fetchData() {
      this.listLoading = true
      gettable().then(response => {
        this.map = response.data
      })
      this.listLoading = false
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
.root .header{
  font-size: 20px;
  font-weight: 600;
}
.root .container{
  padding: 10px;
  display: flex;
  flex-wrap: wrap;
  width: 500px;
}
.container .row{
  display: flex;
  flex: 0 0 50%;
  margin-bottom: 10px;
}
.row .label{
  width: 100px;
}
.row .value{
  margin-left: 30px;
}
</style>
