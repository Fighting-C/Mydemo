<template>
  <div class="dashboard-editor-container">
    <div class=" clearfix">
      <div class="info-container">
        <span class="display_name">Hello {{ name }}</span>
        <span style="font-size:20px;padding-top:20px;display:inline-block;">{{roles}}'s Dashboard</span>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import store from '@/store'

export default {
  name: 'DashboardEditor',
  data() {
    return {
      roles: null
    }
  },created() {
    this.roles = store.getters.roles
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar',
      'roles'
    ])
  }
}
</script>

<style lang="scss" scoped>
  .emptyGif {
    display: block;
    width: 45%;
    margin: 0 auto;
  }

  .dashboard-editor-container {
    background-color: #e3e3e3;
    min-height: 100vh;
    padding: 50px 60px 0px;
    .pan-info-roles {
      font-size: 12px;
      font-weight: 700;
      color: #333;
      display: block;
    }
    .info-container {
      position: relative;
      margin-left: 190px;
      height: 150px;
      line-height: 200px;
      .display_name {
        font-size: 48px;
        line-height: 48px;
        color: #212121;
        position: absolute;
        top: 25px;
      }
    }
  }
</style>
