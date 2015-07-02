package la.ggu.m16.m16chat.cv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bnetp.BNetChannelUser;
import bnetp.BNetChatMessage;
import la.ggu.m16.m16chat.R;
import la.ggu.m16.m16chat.util.ParseUsername;

public class ChanAdapter extends ArrayAdapter<BNetChannelUser> {
    private ArrayList<BNetChannelUser> ChanUsers;
    private Context context;

    public ChanAdapter(Context context, int textViewResourceId, ArrayList<BNetChannelUser> ChanUsers) {
        super(context, textViewResourceId, ChanUsers);
        this.context = context;
        this.ChanUsers = ChanUsers;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.custom_channel_user, null);
        }
        BNetChannelUser bcu = ChanUsers.get(position);
        if (bcu != null) {
            TextView text1 = (TextView) v.findViewById(R.id.channel_user_list_item);
            text1.setText(ParseUsername.parseColor(bcu.username));
        }
        return v;
    }
}