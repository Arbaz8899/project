package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;

import com.entities.Category;
import com.entities.Post;
import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;
import com.techblog.helper.Helper;

public class PostDao {

	Connection con;

	public PostDao(Connection con) {

		this.con = con;
	}

	public ArrayList<Category> getAllCategories() {

		ArrayList<Category> list = new ArrayList<>();

		try {

			String sql = "select * from categories";
			Statement st = this.con.createStatement();
			ResultSet set = st.executeQuery(sql);

			while (set.next()) {
				int cid = set.getInt("cid");
				String name = set.getString("name");
				String description = set.getString("description");
				Category c = new Category(cid, name, description);
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public boolean savePost(Post p) {
		boolean f = false;

		try {

			String sql = "insert into posts(pTitle, pContent, pCode, pPic, catId, userId)values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getpTitle());
			pst.setString(2, p.getpContent());
			pst.setString(3, p.getpCode());
			pst.setString(4, p.getpPic());
			pst.setInt(5, p.getCatId());
			pst.setInt(6, p.getUserId());

			pst.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Post> getAllPost() {

		List<Post> list = new ArrayList<>();
		/* Fetch all the post */
		try {
			PreparedStatement p = con.prepareStatement("select * from posts order by pid desc");

			ResultSet set = p.executeQuery();

			while (set.next()) {
				int pId = set.getInt("pId");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode = set.getString("pCode");
				String pPic = set.getString("pPic");
				Timestamp date = set.getTimestamp("pDate");
				int catId = set.getInt("catId");
				int userId = set.getInt("userId");

				Post post = new Post(pId, pTitle, pContent, pCode, pPic, date, catId, userId);
				list.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Post> getPostByCatId(int catId) {

		List<Post> list = new ArrayList<>();
		/* fetch all post by id */
		try {
			PreparedStatement p = con.prepareStatement("select * from posts where catId = ?");
			p.setInt(1, catId);

			ResultSet set = p.executeQuery();

			while (set.next()) {
				int pId = set.getInt("pId");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode = set.getString("pCode");
				String pPic = set.getString("pPic");
				Timestamp date = set.getTimestamp("pDate");
				int userId = set.getInt("userId");

				Post post = new Post(pId, pTitle, pContent, pCode, pPic, date, catId, userId);
				list.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Post getPostByPostId(int postId) {
		Post post = null;
		String q = "select * from posts where pid=?";
		try {
			PreparedStatement p = this.con.prepareStatement(q);
			p.setInt(1, postId);
			
			ResultSet set = p.executeQuery();
			if(set.next()) {
				int pId = set.getInt("pId");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode = set.getString("pCode");
				String pPic = set.getString("pPic");
				Timestamp date = set.getTimestamp("pDate");
				int userId = set.getInt("userId");
				int cid = set.getInt("catId");

				post = new Post(pId, pTitle, pContent, pCode, pPic, date, cid, userId);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
}
