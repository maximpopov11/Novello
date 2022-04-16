package com.yn_1.novello_app.reading;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;

/**
 * {@inheritDoc}
 *
 * @author Roba Abbajabal
 */
public class ReadingFragment extends Fragment implements ReadingContract.View {

    private WebView webView;

    // Presenter accessible from View
    private ReadingContract.Presenter presenter;

    /**
     * Creates a new fragment instance, using specific arguments to be added to the bundle.
     *
     * @return A new instance of fragment ReadingFragment.
     */
    public static ReadingFragment newInstance() {
        ReadingFragment fragment = new ReadingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Params
        int bookID = ReadingFragmentArgs.fromBundle(getArguments()).getBookID();
        String readingLink = ReadingFragmentArgs.fromBundle(getArguments()).getReadingLink();

        // Create Presenter
        presenter = new ReadingPresenter(new ReadingModel(bookID, readingLink), this);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reading, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.readingView);
        webView.loadUrl(ReadingFragmentArgs.fromBundle(getArguments()).getReadingLink());

        presenter.onPageLoad(((NavBarActivity)getActivity()).getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop() {
        super.onStop();
        presenter.onPageLoad(((NavBarActivity)getActivity()).getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getProgress() {
        return webView.getScrollY() - webView.getTop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getProgressPercentage() {
        return (double) getProgress() / webView.getContentHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jumpToProgress(int progress) {
        webView.setScrollY(progress + webView.getTop());
    }
}