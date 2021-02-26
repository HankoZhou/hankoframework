<template>
  <div class="menu-wrapper">

    <el-menu-item >
      <svg-icon  icon-class="home"></svg-icon>
      <span slot="title">首页</span>
    </el-menu-item>

    <template v-for="item in menuList" v-if="item.children">

     <el-submenu  :index="item.name||item.uri" :key="item.name">
        <template slot="title">
          <svg-icon  :icon-class="item.icon"></svg-icon>
          <span v-if="item.name" slot="title">{{item.name}}</span>
        </template>

        <template v-for="child in item.children">
          <sidebar-item :is-nest="true" class="nest-menu" v-if="child.children&&child.children.length>0" :routes="[child]" :key="child.uri"></sidebar-item>

          <router-link  :to="child.uri" :key="child.name">
            <el-menu-item :index="child.uri">
              <svg-icon v-if="child.icon" :icon-class="child.icon"></svg-icon>
              <span v-if="child.name" slot="title">{{child.name}}</span>
            </el-menu-item>
          </router-link>
        </template>
      </el-submenu>

    </template>
  </div>
</template>

<script>
import { menuList} from "@/api/login";

export default {
  name: 'SidebarItem',
  props: {
    routes: {
      type: Array
    },
    isNest: {
      type: Boolean,
      default: false
    }
  },
  data(){
    return {
      menuList: null
    }
  },
  created() {
    this.getMenuList();
  },
  methods: {
    hasOneShowingChildren(children) {
      const showingChildren = children.filter(item => {
        return !item.hidden
      })
      if (showingChildren.length === 1) {
        return true
      }
      return false
    },
    getMenuList(){
      menuList().then(response => {
        this.menuList = response.data;
        // console.info(menuList)
      });
    }
  }

}
</script>
